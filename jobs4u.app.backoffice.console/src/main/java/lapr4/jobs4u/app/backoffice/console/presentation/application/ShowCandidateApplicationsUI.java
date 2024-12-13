package lapr4.jobs4u.app.backoffice.console.presentation.application;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.applicationmanagement.application.ShowCandidateApplicationsController;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ShowCandidateApplicationsUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterApplicationUI.class);
    private final ShowCandidateApplicationsController controller = new ShowCandidateApplicationsController();

    @Override
    protected boolean doShow() {

        final List<Candidate> candidates = controller.allCandidates();

        Candidate candidate = null;

        int cont = 1;
        for (final Candidate c : candidates) {
            System.out.print(cont + ". ");
            System.out.printf("Candidate: %s\n", c.identity());
            cont++;
        }

        final int option2 = Console.readInteger("\nSelect a Candidate: ");
        if (option2 == 0) {
            System.out.println("No Candidate selected");
        } else {
            try {
                candidate = candidates.get(option2 - 1);

            } catch (Exception ex) {
                System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
            }
        }

        List<Application> list = controller.showCandidateApplications(candidate);

        cont = 1;
        for (final Application a : list) {
            System.out.print(cont + ". ");
            System.out.printf("Application: %s\n", a.toString());
            cont++;
        }
        return false;
    }

    @Override
    public String headline() {
        return "ShowCandidateInfoPlusApplicationUI";
    }
}
