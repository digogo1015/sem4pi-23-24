package lapr4.jobs4u.app.backoffice.console.presentation.plugin;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.pluginmanagement.application.SelectInterviewModelController;
import lapr4.jobs4u.pluginmanagement.domain.PlugIn;

import java.util.List;

public class SelectInterviewModelUI extends AbstractUI {

    private final SelectInterviewModelController controller = new SelectInterviewModelController();

    @Override
    protected boolean doShow() {

        final List<JobOpening> jobOpenings = controller.allJobOpenings();

        JobOpening jobOpening = null;

        PlugIn interviewModel;


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

            } catch (Exception ex) {
                System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
            }
        }

        final List<PlugIn> interviewModels = controller.allInterviewModels();

        cont = 1;
        for (final PlugIn requirement : interviewModels) {
            System.out.print(cont + ". ");
            System.out.println(requirement.toString());
            cont++;
        }
        final int option = Console.readInteger("\nSelect a Interview Model: ");
        if (option == 0) {
            System.out.println("No Interview Model selected");
        } else {
            try {
                interviewModel = interviewModels.get(option - 1);
                if (jobOpening != null) {
                    controller.selectInterviewModel(interviewModel, jobOpening);
                    System.out.println("Operation sucess!");
                }
            } catch (Exception ex) {
                System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
            }
        }

        return false;
    }

    @Override
    public String headline() {
        return "Select a Interview Model";
    }
}
