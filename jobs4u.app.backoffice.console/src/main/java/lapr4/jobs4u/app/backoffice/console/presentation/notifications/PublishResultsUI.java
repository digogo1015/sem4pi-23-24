package lapr4.jobs4u.app.backoffice.console.presentation.notifications;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.notificationmanagement.application.PublishResultsController;
import lapr4.jobs4u.rankmanagement.domain.Order1;
import lapr4.jobs4u.rankmanagement.domain.Ranking;

import java.util.List;

@SuppressWarnings({"squid:S106"})
public class PublishResultsUI extends AbstractUI {
    private final PublishResultsController controller = new PublishResultsController();

    @Override
    protected boolean doShow() {
        List<JobOpening> jobOpenings = controller.allJobOpeningsInResults();

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
                    final JobOpening jobOpening = jobOpenings.get(option - 1);
                    final Customer costumer = jobOpening.customer();
                    final Ranking ranking = controller.findRankingByJobReference(jobOpening.identity());
                    final List<Order1> rankingList = ranking.ranking();
                    ranking.sortRankingByRank();

                    System.out.println("\nCostumer to Notify");
                    System.out.printf("#  %-30s%-30s\n", "Name", "Email Address");
                    System.out.printf("1. %-30s%-30s\n", costumer.user().name(), costumer.user().email());
                    System.out.println("\nCandidates to Notify");

                    int c = 1;
                    System.out.printf("#  %-30s%-30s%-30s\n", "Name", "Email Address", "Rank");
                    for (Order1 order : rankingList) {
                        if (order.applicationOfRank().emailSent())
                            continue;
                        System.out.printf("%d. %-30s%-30s%-30s\n", c, order.applicationOfRank().candidate().fullName(), order.applicationOfRank().candidate().emailAddress(), order.positionOfRanking().rank().toString());
                        c++;
                    }

                    int option1 = Console.readInteger("\nType '1' to confirm, '0' to cancel: ");
                    while (true){
                        if (option1 == 0) {
                            System.out.println("Operation Cancelled");
                            return true;
                        } else if (option1 == 1) {
                            break;
                        } else {
                            System.out.println("Invalid Option");
                            option1 = Console.readInteger("\nType '1' to confirm, '0' to cancel: ");
                        }
                    }

                    int i = 0;
                    for (Order1 order : rankingList) {
                        if(i <= jobOpening.numberOfVacancies())
                            controller.defineApplicationStateAccepted(order.applicationOfRank());
                        else
                            controller.defineApplicationStateRejected(order.applicationOfRank());

                        i++;
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

