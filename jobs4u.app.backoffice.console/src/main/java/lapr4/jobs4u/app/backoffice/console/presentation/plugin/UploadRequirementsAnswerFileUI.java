package lapr4.jobs4u.app.backoffice.console.presentation.plugin;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationId;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.pluginmanagement.application.UploadRequirementsAnswerFileController;

import java.util.List;

public class UploadRequirementsAnswerFileUI extends AbstractUI {

    private final UploadRequirementsAnswerFileController controller = new UploadRequirementsAnswerFileController();

    @Override
    public boolean doShow() {
        final List<JobOpening> jobOpenings = controller.allJobOpeningsWithRequirementsSpecification();

        if (jobOpenings.isEmpty()) {
            System.out.println("There are no Job Openings registered");
        } else {
            int cont = 1;
            headline();
            System.out.print(listHeader() + "\n");
            for (final JobOpening jobOpening : jobOpenings) {
                System.out.printf("%d. ", cont);
                System.out.printf(" %-20s%-20s\n", jobOpening.identity().toString(), jobOpening.title());
                cont++;
            }

            final int option = Console.readInteger("\nEnter the number for the desired Job Opening: ");
            if (option == 0) {
                System.out.println("No Job Opening selected");
            } else {
                try {
                    JobOpening jobOpening = jobOpenings.get(option - 1);
                    List<Application> applications = controller.applicationsOfJobOpening(jobOpening);
                    List<ApplicationId> invalidApplications = controller.checkFiles(jobOpening.requirementsSpecification(), applications);

                    if (invalidApplications.isEmpty()) {
                        System.out.println("All Applications have valid files");
                        System.out.println("Operating Success, Files at this path " + "jobs4u.core/src/main/java/lapr4/jobs4u/pluginmanagement/domain/GeneratedRequirementTemplates/" + jobOpening.identity().toString() + "\n");
                    } else {
                        System.out.println("Applications that have invalid Requirements Files");
                        System.out.printf("#  %-20s", "Job Reference");
                        for (ApplicationId applicationId : invalidApplications)
                            System.out.println("\nApplicationId: "+applicationId.toString());
                    }

                } catch (Exception ex) {
                    System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
                }
            }
        }
        return true;
    }

    public String headline() {
        return "List Of Job Openings";
    }

    public String listHeader() {
        return String.format("#  %-20s%-20s", "Job Reference", "Job Title");
    }

}
