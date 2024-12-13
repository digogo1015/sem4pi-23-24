package lapr4.jobs4u.app.backoffice.console.presentation.application;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.rankmanagement.application.RankCandidateController;
import lapr4.jobs4u.rankmanagement.domain.Order1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings({"squid:S106"})
public class RankCandidatesUI extends AbstractUI {
    private final RankCandidateController controller = new RankCandidateController();

    @Override
    protected boolean doShow() {
        List<JobOpening> jobOpenings = controller.allJobOpeningsInAnalysis();

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
                    JobOpening jobOpening = jobOpenings.get(option - 1);
                    Integer numberOfVacancies = jobOpening.numberOfVacancies();
                    int candidatesToRank;
                    int opt;
                    while (true) {
                        System.out.println("Number of Vacancies: " + numberOfVacancies);
                        System.out.println("How many Candidates will you rank? ");
                        System.out.println("1. Rank " + (numberOfVacancies + numberOfVacancies / 2) + " candidates");
                        System.out.println("2. Rank " + (numberOfVacancies * 2) + " candidates");
                        System.out.println("3. Rank " + (numberOfVacancies + numberOfVacancies * 2) + " candidates");
                        System.out.println("0. To Leave");

                        try {
                            opt = Console.readInteger("\nChoose an option: ");
                            if (opt == 0) {
                                System.out.println("Exiting");
                                return true;
                            }

                            switch (opt) {
                                case 1:
                                    candidatesToRank = numberOfVacancies + (numberOfVacancies / 2);
                                    break;
                                case 2:
                                    candidatesToRank = numberOfVacancies * 2;
                                    break;
                                case 3:
                                    candidatesToRank = numberOfVacancies + (numberOfVacancies * 2);
                                    break;
                                default:
                                    System.out.println("Invalid option. Please choose 1, 2, 3, or 0 to leave.");
                                    continue;
                            }

                            System.out.println("Candidates to Rank: " + candidatesToRank);
                            break;

                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                        }
                    }

                    final List<Application> applications = controller.applicationsOfJobOpening(jobOpening);

                    if(applications.isEmpty()){
                        System.out.println("There are no Applications for this Job Opening");
                        return true;
                    }

                    final List<Order1> ranking = new ArrayList<>();
                    List<Integer> ints = new ArrayList<>();
                    int n = 1;

                    System.out.println("If you dont want to rank a Candidate, insert '0' ");
                    for (final Application application : applications) {
                        if (n >= candidatesToRank + 1) {
                            System.out.println("Limit of Candidates ranked reached");
                            break;
                        } else if ((application.jobOpening().reference().equals(jobOpening.reference()))) {
                            System.out.printf("\n%d. %s\n", n, application.candidate().toString());
                            while (true) {
                                try {
                                    final int rank = Console.readInteger("\nEnter the rank for this Candidate: ");
                                    if (rank < 0) {
                                        System.out.println("Rank must be a positive integer.");
                                        continue;
                                    } else if (rank > candidatesToRank) {
                                        System.out.println("Rank must lower than the number of Candidates to Rank which is: " + candidatesToRank + ".");
                                        continue;
                                    } else if (rank == 0) {
                                        System.out.println("Candidate not Ranked");
                                        break;
                                    }

                                    if (!ints.contains(rank)) {
                                        ints.add(rank);
                                        ranking.add(controller.addRank(application, rank));
                                        break;
                                    } else {
                                        System.out.println("Rank already assigned, please try again");
                                        System.out.print("Ranks utilized: ");
                                        System.out.println(ints.stream()
                                                .map(String::valueOf)
                                                .collect(Collectors.joining(", ")));
                                    }
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Invalid rank entered. Please try again.");
                                }
                            }
                        }
                        n++;
                    }
                    if (!controller.checkIfRankExists(jobOpening.identity(), ranking)) {
                        System.out.println("Rank Submitted Successfully");
                    } else {
                        controller.editRank(jobOpening.reference(), ranking);
                        System.out.println("Rank Edited Successfully");
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

