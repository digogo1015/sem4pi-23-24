package lapr4.jobs4u.app.backoffice.console.presentation.application;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.app.backoffice.console.presentation.candidate.CandidatePrinter;
import lapr4.jobs4u.applicationmanagement.application.RegisterApplicationController;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationId;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class RegisterApplicationUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterApplicationUI.class);

    private final RegisterApplicationController controller = new RegisterApplicationController();

    @Override
    protected boolean doShow() {

        final List<Candidate> candidateList = controller.allCandidates();

        if(candidateList.isEmpty()) {
            System.out.println("There are no Candidates registered");

        } else {

            Candidate candidate = null;

            int cont = 1;
            for (final Candidate c : candidateList) {
                System.out.print(cont + ". ");
                new CandidatePrinter().printInfoCandidate(c);
                cont++;
            }

            final int option = Console.readInteger("\nSelect a Candidate: ");
            if (option == 0) {
                System.out.println("No Candidate selected");
            } else {
                try {
                    candidate = candidateList.get(option - 1);

                } catch (Exception ex) {
                    System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
                }
            }

            final List<JobOpening> jobOpeningList = controller.allJobOpenings();

            JobOpening jobOpening = null;

            cont = 1;
            for (final JobOpening j : jobOpeningList) {
                System.out.print(cont + ". ");
                System.out.printf("REF: %s\n", j.identity());
                cont++;
            }

            final int option2 = Console.readInteger("\nSelect a JobOpening: ");
            if (option2 == 0) {
                System.out.println("No JobOpening selected");
            } else {
                try {
                    jobOpening = jobOpeningList.get(option2 - 1);

                } catch (Exception ex) {
                    System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
                }
            }

            String applicationId = Console.readLine("\nInput application ID");
            String pathToFolder = Console.readLine("\nInput path to application folder");

            controller.registerApplication(new ApplicationId(applicationId), new Date(), pathToFolder, candidate, jobOpening);
        }
        return false;
    }

    @Override
    public String headline() {
        return "RegisterApplicationUI";
    }
}
