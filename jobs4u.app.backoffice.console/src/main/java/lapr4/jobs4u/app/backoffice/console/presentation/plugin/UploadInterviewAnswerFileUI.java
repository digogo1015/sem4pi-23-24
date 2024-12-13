package lapr4.jobs4u.app.backoffice.console.presentation.plugin;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationId;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.pluginmanagement.application.UploadInterviewAnswerFileController;

import java.util.List;

public class UploadInterviewAnswerFileUI extends AbstractUI {

    private final UploadInterviewAnswerFileController controller = new UploadInterviewAnswerFileController();

    @Override
    public boolean doShow() {
        final List<JobOpening> jobOpenings = controller.allJobOpeningsWithInterview();

        if (jobOpenings.isEmpty()) {
            System.out.println("There are no Job Openings registered with recruitment process!");
        } else {
            int cont = 1;
            headline();
            System.out.print(listHeader() + "\n");
            for (final JobOpening jobOpening : jobOpenings) {
                System.out.printf("%d. ", cont);
                System.out.printf(" %-20s%-20s\n", jobOpening.identity().toString(), jobOpening.title());
                cont++;
            }

            int option;
            do {
                option = Console.readInteger("\nEnter the number for the desired Job Opening: ");
            }while (option < 1 || option > jobOpenings.size() + 1);

            try {
                JobOpening jobOpening = jobOpenings.get(option - 1);
                List<Application> applications = controller.applicationsOfJobOpening(jobOpening);
                List<ApplicationId> invalidApplications = controller.checkFiles(jobOpening.interviewModel(), applications);

                if (invalidApplications.isEmpty()) {
                    System.out.println("All Applications have valid files");
                    System.out.println("Operating Success, Files at this path " + "jobs4u.core/src/main/java/lapr4/jobs4u/pluginmanagement/domain/GeneratedInterviewTemplates/" + jobOpening.identity().toString() + "\n");
                } else {
                    System.out.println("Applications that have invalid Interview Files");
                    System.out.printf("#  %-20s", "Job Reference");
                    for (ApplicationId applicationId : invalidApplications)
                        System.out.println("\nApplicationId: "+applicationId.toString());
                }

            }catch (NullPointerException e ){
                System.out.println("Missing a inteview template!");
            }
            catch (Exception ex) {
                System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
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
