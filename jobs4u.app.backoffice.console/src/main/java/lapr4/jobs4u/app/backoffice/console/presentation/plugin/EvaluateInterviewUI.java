package lapr4.jobs4u.app.backoffice.console.presentation.plugin;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.pluginmanagement.application.EvaluateInterviewModelController;

import java.util.List;

public class EvaluateInterviewUI extends AbstractUI {

    private final EvaluateInterviewModelController controller = new EvaluateInterviewModelController();

    @Override
    protected boolean doShow() {

        final List<JobOpening> jobOpenings = controller.allJobOpeningsWithInterviewInAnalysis();

        JobOpening jobOpening;

        int cont = 1;
        for (final JobOpening jobopening : jobOpenings) {
            System.out.print(cont + ". ");
            System.out.println(jobopening.toString());
            cont++;
        }
        final int option1 = Console.readInteger("\nSelect a Job Opening: ");
        if (option1 == 0) {
            System.out.println("No Job Opening selected");
        } else {
            try {
                jobOpening = jobOpenings.get(option1 - 1);

                final List<Application> applications = controller.applicationsNotKnown(jobOpening);

                controller.evaluateInterviews(jobOpening, applications);

            } catch (Exception ex) {
                System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
            }
        }

        return false;
    }

    @Override
    public String headline() {
        return "Evaluate Interviews";
    }
}
