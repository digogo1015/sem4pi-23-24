/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package lapr4.jobs4u.app.backoffice.console.presentation;

import lapr4.jobs4u.Application;
import lapr4.jobs4u.app.backoffice.console.presentation.application.*;
import lapr4.jobs4u.app.backoffice.console.presentation.authz.*;
import lapr4.jobs4u.app.backoffice.console.presentation.candidate.*;
import lapr4.jobs4u.app.backoffice.console.presentation.customer.RegisterCustomerAction;
import lapr4.jobs4u.app.backoffice.console.presentation.jobOpening.*;
import lapr4.jobs4u.app.backoffice.console.presentation.notifications.PublishResultsAction;
import lapr4.jobs4u.app.backoffice.console.presentation.plugin.*;
import lapr4.jobs4u.app.common.console.presentation.authz.MyUserMenu;
import lapr4.jobs4u.usermanagement.domain.UserRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS

    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;

    private static final int LIST_BACK_OFFICE_USERS_OPTION = 3;
    private static final int DEACTIVATE_USER_OPTION = 4;
    private static final int ACTIVATE_USER_OPTION = 5;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 6;

    // SETTINGS

    private static final int SET_KITCHEN_ALERT_LIMIT_OPTION = 1;

    // OPERATOR

    private static final int REGISTER_CANDIDATE = 1;
    private static final int LIST_ALL_CANDIDATES = 2;
    private static final int GENERATE_REQUIREMENTS_TEMPLATE = 3;
    private static final int REGISTER_APPLICATION = 4;
    private static final int ACTIVATE_CANDIDATE = 5;
    private static final int DEACTIVATE_CANDIDATE = 6;
    private static final int UPLOAD_REQUIREMENTS_FILE = 7;


    // CUSTOMER_MANAGER

    private static final int REGISTER_CUSTOMER_OPTION = 1;
    private static final int LIST_CANDIDATE_INFORMATION = 2;
    private static final int SELECT_REQUIREMENT_FOR_JOB_OPENING = 3;
    private static final int SELECT_INTERVIEW_FOR_JOB_OPENING = 4;
    private static final int REGISTER_JOB_OPENING = 5;
    private static final int LIST_JOB_OPENING = 6;
    private static final int LIST_APPLICATION_BY_JOB_OPENING = 7;
    private static final int LIST_CANDIDATE_APPLICATIONS = 8;
    private static final int GENERATE_INTERVIEW_TEMPLATE = 9;
    private static final int SETUP_PHASES = 10;
    private static final int RANK_CANDIDATES = 11;
    private static final int LIST_CANDIDATES_BY_POINTS = 12;
    private static final int EVALUATE_INTERVIEW = 13;
    private static final int PUBLISH_RESULTS = 14;
    private static final int OPEN_PHASE = 15;
    private static final int UPLOAD_INTERVIEWS_FILE = 16;
    private static final int EDIT_JOB_OPENING = 17;
    private static final int TOP_20_WORDS = 18;


    // LANGUAGE_ENGINEER

    private static final int DEPLOY_PLUGIN = 1;
    private static final int LANGUAGE_ENGINEER_OPTION2 = 2;

    // MAIN MENU

    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SETTINGS_OPTION = 4;


    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final var menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Backoffice [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Backoffice [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final var mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(UserRoles.POWER_USER, UserRoles.ADMIN)) {
            final var usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            //final var settingsMenu = buildAdminSettingsMenu();
            //mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);

        } else if (authz.isAuthenticatedUserAuthorizedTo(UserRoles.OPERATOR)) {
            final var operatorMenu = buildOperatorMenu();
            mainMenu.addSubMenu(2, operatorMenu);

        } else if (authz.isAuthenticatedUserAuthorizedTo(UserRoles.CUSTOMER_MANAGER)) {
            final var customerManagerMenu = buildCustomerManagerMenu();
            mainMenu.addSubMenu(2, customerManagerMenu);

        } else if (authz.isAuthenticatedUserAuthorizedTo(UserRoles.LANGUAGE_ENGINEER)) {
            final var languageEngineerMenu = buildLanguageEngineerMenu();
            mainMenu.addSubMenu(2, languageEngineerMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildAdminSettingsMenu() {
        final var menu = new Menu("Settings >");

        menu.addItem(SET_KITCHEN_ALERT_LIMIT_OPTION, "Set kitchen alert limit",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }


    private Menu buildUsersMenu() {
        final var menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(LIST_BACK_OFFICE_USERS_OPTION, "List all BackOffice Users", new ListBackOfficeUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACTIVATE_USER_OPTION, "Activate User", new ActivateUserAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildOperatorMenu() {
        final var menu = new Menu("Operator >");
        menu.addItem(REGISTER_CANDIDATE, "Register a Candidate",
                new RegisterCandidateAction());
        menu.addItem(LIST_ALL_CANDIDATES, "List all Candidates",
                new ListCandidatesAction());
        menu.addItem(GENERATE_REQUIREMENTS_TEMPLATE, "Generate Requirements Template",
                new GenerateRequirementsTemplateAction());
        menu.addItem(REGISTER_APPLICATION, "Register an Application",
                new RegisterApplicationAction());
        menu.addItem(ACTIVATE_CANDIDATE, "Enable a Candidate",
                new ActivateCandidateAction());
        menu.addItem(DEACTIVATE_CANDIDATE, "Disable a Candidate",
                new DeactivateCandidateAction());
        menu.addItem(UPLOAD_REQUIREMENTS_FILE, "Upload Requirements Answer Files",
                new UploadRequirementsAnswerFileAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildCustomerManagerMenu() {
        final var menu = new Menu("Customer Manager >");
        menu.addItem(REGISTER_CUSTOMER_OPTION, "Register a Customer",
                new RegisterCustomerAction());
        menu.addItem(LIST_CANDIDATE_INFORMATION, "Show Candidate Information",
                new ShowCandidateInfoAction());
        menu.addItem(SELECT_REQUIREMENT_FOR_JOB_OPENING, "Select Requirement for JobOpening",
                new SelectRequirementsSpecificationAction());
        menu.addItem(SELECT_INTERVIEW_FOR_JOB_OPENING, "Select Interview Model for JobOpening",
                new SelectInterviewModelAction());
        menu.addItem(REGISTER_JOB_OPENING, "Register a Job Opening",
                new RegisterJobOpeningAction());
        menu.addItem(LIST_JOB_OPENING, "List Job Openings",
                new ListJobOpeningAction());
        menu.addItem(LIST_APPLICATION_BY_JOB_OPENING, "List Applications by Job Opening",
                new ListApplicationByJobOpeningAction());
        menu.addItem(LIST_CANDIDATE_APPLICATIONS, "Show Candidate Applications",
                new ShowCandidateApplicationsAction());
        menu.addItem(GENERATE_INTERVIEW_TEMPLATE, "Generate Interview Template",
                new GenerateInterviewTemplateAction());
        menu.addItem(SETUP_PHASES, "Setup Phases for a Job Opening",
                new SetupPhasesAction());
        menu.addItem(RANK_CANDIDATES, "Rank Candidates for a Job Opening",
                new RankCandidatesAction());
        menu.addItem(LIST_CANDIDATES_BY_POINTS, "List Candidates by Interview Points",
                new ListCandidatesByPointsAction());
        menu.addItem(EVALUATE_INTERVIEW, "Evaluate Interviews",
                new EvaluateInterviewAction());
        menu.addItem(PUBLISH_RESULTS, "Publish Results and Notify Candidates and Customer",
                new PublishResultsAction());
        menu.addItem(OPEN_PHASE, "Open or Close a phase of Job Opening",
                new OpenClosePhaseAction());
        menu.addItem(UPLOAD_INTERVIEWS_FILE, "Upload Interview Answer Files",
                new UploadInterviewAnswerFileAction());
        menu.addItem(EDIT_JOB_OPENING, "Edit a Job Opening",
                new EditJobOpeningAction());
        menu.addItem(TOP_20_WORDS, "Top 20 Words",
                new Top20WordsAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildLanguageEngineerMenu() {
        final var menu = new Menu("Language Engineer >");
        menu.addItem(DEPLOY_PLUGIN, "Deploy a PlugIn",
                new DeployPluginAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

}
