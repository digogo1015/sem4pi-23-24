package lapr4.jobs4u.app.backoffice.console;

import lapr4.jobs4u.app.backoffice.console.presentation.MainMenu;
import lapr4.jobs4u.app.common.console.BaseApp;
import lapr4.jobs4u.app.common.console.presentation.authz.LoginUI;
import lapr4.jobs4u.candidatemanagement.eventhandlers.ErrorCreatingCandidateWatchDog;
import lapr4.jobs4u.candidatemanagement.eventhandlers.NewUserForCandidateWatchDog;
import lapr4.jobs4u.candidatemanagement.events.ErrorCreatingCandidateEvent;
import lapr4.jobs4u.candidatemanagement.events.NewUserForCandidateEvent;
import lapr4.jobs4u.customermanagement.eventhandlers.ErrorCreatingCustomerWatchDog;
import lapr4.jobs4u.customermanagement.eventhandlers.NewUserForCustomerWatchDog;
import lapr4.jobs4u.customermanagement.events.ErrorCreatingCustomerEvent;
import lapr4.jobs4u.customermanagement.events.NewUserForCustomerEvent;
import lapr4.jobs4u.infrastructure.authz.AuthenticationCredentialHandler;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.notificationmanagement.event.ApplicationChangeNotificationEvent;
import lapr4.jobs4u.notificationmanagement.event.PhaseChangeNotificationEvent;
import lapr4.jobs4u.notificationmanagement.eventhandlers.NotificationForApplicationChanceWatchDog;
import lapr4.jobs4u.notificationmanagement.eventhandlers.NotificationForPhaseChanceWatchDog;
import lapr4.jobs4u.usermanagement.domain.UserPasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;

/**
 * @author Paulo Gandra Sousa
 */
@SuppressWarnings("squid:S106")
public final class AppBackoffice extends BaseApp {

    /**
     * avoid instantiation of this class.
     */
    private AppBackoffice() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {

        AuthzRegistry.configure(PersistenceContext.repositories().users(), new UserPasswordPolicy(),
                new PlainTextEncoder());

        new AppBackoffice().run(args);
    }

    @Override
    protected void doMain(final String[] args) {
        // login and go to main menu
        if (new LoginUI(new AuthenticationCredentialHandler()).show()) {
            // go to main menu
            final var menu = new MainMenu();
            menu.mainLoop();
        }
    }

    @Override
    protected String appTitle() {
        return "Back Office";
    }

    @Override
    protected String appGoodbye() {
        return "Back Office";
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doSetupEventHandlers(final EventDispatcher dispatcher) {
        dispatcher.subscribe(new NewUserForCustomerWatchDog(), NewUserForCustomerEvent.class);
        dispatcher.subscribe(new ErrorCreatingCustomerWatchDog(), ErrorCreatingCustomerEvent.class);
        dispatcher.subscribe(new NewUserForCandidateWatchDog(), NewUserForCandidateEvent.class);
        dispatcher.subscribe(new ErrorCreatingCandidateWatchDog(), ErrorCreatingCandidateEvent.class);
        dispatcher.subscribe(new NotificationForPhaseChanceWatchDog(), PhaseChangeNotificationEvent.class);
        dispatcher.subscribe(new NotificationForApplicationChanceWatchDog(), ApplicationChangeNotificationEvent.class);

    }
}
