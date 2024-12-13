package lapr4.jobs4u.app.backoffice.console.presentation.plugin;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.pluginmanagement.application.GenerateInterviewTemplateController;
import lapr4.jobs4u.pluginmanagement.domain.PlugIn;

import java.util.List;

public class GenerateInterviewTemplateUI extends AbstractUI  {

    private final GenerateInterviewTemplateController controller = new GenerateInterviewTemplateController();

    @Override
    public boolean doShow() {
        final List<JobOpening> jobOpenings = controller.allJobOpeningsWithInterviewInAnalysis();

        if (jobOpenings.isEmpty()) {
            System.out.println("There are no Job Openings registered");
        } else {
            int cont = 1;
            headline();
            System.out.print(listHeader() + "\n");
            for (final JobOpening jobOpening : jobOpenings) {
                System.out.printf("%d. ",cont);
                System.out.printf(" %-20s%-20s\n" , jobOpening.identity().toString() , jobOpening.title());
                cont++;
            }
            String path = null;
            final int option = Console.readInteger("\nEnter the number for the desired Job Opening: ");
            if (option == 0) {
                System.out.println("No Job Opening selected");
            } else {
                try {
                    JobOpening jobOpening = jobOpenings.get(option - 1);
                    PlugIn template = jobOpening.interviewModel();
                    List<Application> applications = controller.applicationsOfJobOpening(jobOpening);
                    controller.generateTemplate(template, jobOpening.identity() ,applications);

                    System.out.println("Operating Success, Files at this path " + "jobs4u.core/src/main/java/lapr4/jobs4u/pluginmanagement/domain/GeneratedInterviewTemplates/" + jobOpening.identity().toString() + "\n");

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
