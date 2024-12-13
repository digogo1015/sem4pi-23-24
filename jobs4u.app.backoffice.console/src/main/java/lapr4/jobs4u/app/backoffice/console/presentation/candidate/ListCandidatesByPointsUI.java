package lapr4.jobs4u.app.backoffice.console.presentation.candidate;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.applicationmanagement.application.ListCandidatesByPointsController;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

import java.util.List;

@SuppressWarnings({"squid:S106"})
public class ListCandidatesByPointsUI extends AbstractUI {
    private final ListCandidatesByPointsController controller = new ListCandidatesByPointsController();

    @Override
    protected boolean doShow() {
        List<JobOpening> jobOpenings = controller.allJobOpeningsWithInterviewInAnalysis();

        if (jobOpenings.isEmpty()) {
            System.out.println("\nNo Job Openings");
        } else {
            int cont = 1;
            headline();
            System.out.print(listHeader() + "\n");
            for (final JobOpening jobOpening : jobOpenings) {
                System.out.printf("%d. %-20s%-20s\n", cont, jobOpening.identity().toString(), jobOpening.title());
                cont++;
            }

            final int option = Console.readInteger("\nEnter the number for the desired Job Opening: ");
            if (option == 0) {
                System.out.println("No Job Opening selected");
            } else {
                try {
                    List <Application> applicationsSorted = controller.sortApplicationsByInterviewPoints(jobOpenings.get(option - 1));
                    int index = 1;

                    System.out.printf("#  %-20s%-20s%-20s\n", "Candidate Name", "Application ID", "Points");
                    for(Application application : applicationsSorted) {
                        System.out.printf("%d. %-20s%-20s%-20s\n",index, application.candidate().fullName(), application.applicationId(), application.interview().interviewPoints());
                        index++;
                    }

                } catch (Exception ex) {
                    System.out.println("Unfortunately there was an unexpected error in the application");
                }
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "List of Job Openings";
    }

    public String listHeader() {
        return String.format("#  %-20s%-20s", "Job Reference", "Job Title");
    }

}

