package lapr4.jobs4u.app.backoffice.console.presentation.jobOpening;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.app.backoffice.console.presentation.customer.RegisterCustomerUI;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningController;
import lapr4.jobs4u.jobopeningmanagement.application.SetupPhasesController;

import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;


public class SetupPhasesUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterCustomerUI.class);
    private final SetupPhasesController setupPhasesController = new SetupPhasesController();


    @Override
    protected boolean doShow() {

        try {

            List<JobOpening> listOfJobOpenings = setupPhasesController.getListOfJobOpenings();
            int cont = 1;
            if (listOfJobOpenings.isEmpty()) {
                System.out.println("No Job Openings available!");
                throw new IllegalArgumentException();
            }
            for (JobOpening jobOpening : listOfJobOpenings) {
                System.out.print(cont + ". ");
                System.out.println(jobOpening);
                cont++;
            }
            final int jobOpeningOption = Console.readInteger("Select a job Opening:");
            if (jobOpeningOption > listOfJobOpenings.size() + 1 || jobOpeningOption == 0) {
                throw new IllegalArgumentException();
            }
            JobOpening jobOpening = listOfJobOpenings.get(jobOpeningOption - 1);

            if (jobOpening.hasRecruitmentProcess()){
                System.out.println("This Job opening already has a Recruitment process!!");
                return false;
            }

            LocalDate screeningBegDate;
            LocalDate interviewBegDate = null;
            LocalDate analysisBegDate;
            LocalDate resultBegDate;
            LocalDate resultEndDate;

            final boolean hasInterview = askBoolean("Has interview? (y/n)");

            final LocalDate applicationBegDate = askForDate("Application Phase beginneng date");
            do {
                screeningBegDate = askForDate("Screening Phase beginneng date (Application end date)");
            } while (screeningBegDate.isBefore(applicationBegDate));

            if (hasInterview) {
                do {
                    interviewBegDate = askForDate("Interview Phase beginneng date (Screening end date)");
                } while (interviewBegDate.isBefore(screeningBegDate));
                do {
                    analysisBegDate = askForDate("Analysis Phase beginneng date (Interview end date)");
                } while (analysisBegDate.isBefore(interviewBegDate));
            } else {
                do {
                    analysisBegDate = askForDate("Analysis Phase beginneng date (Interview end date)");
                } while (analysisBegDate.isBefore(screeningBegDate));
            }
            do {
                resultBegDate = askForDate("Result Phase beginneng date (Analysis end date)");
            } while (resultBegDate.isBefore(analysisBegDate));
            do {
                resultEndDate = askForDate("Result Phase ending date");
            } while (resultEndDate.isBefore(resultBegDate));


            boolean done = this.setupPhasesController.setupPhases(jobOpening, hasInterview, applicationBegDate, screeningBegDate,
                    interviewBegDate, analysisBegDate, resultBegDate, resultEndDate);
            if (done) {
                System.out.println("Created successfully!");
            }

        }catch (Exception ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");        }

        return false;
    }

    private boolean askBoolean(String prompt) {
        while (true){
            final String hasInterviewOption = Console.readLine("Has interview? (y/n)");
            if (hasInterviewOption.equals("y")) return true;
            if (hasInterviewOption.equals("n")) return false;
        }

    }

    private LocalDate askForDate(String prompt) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println(prompt + " (dd-MM-yyyy)");
        while (true) {
            String input = scanner.nextLine();
            try {

                return LocalDate.parse(input, formatter); // Attempt to parse the date
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Please use the format DD-MM-YYYY:");
            }
        }
    }

    @Override
    public String headline() {
        return "Setup Phases";
    }
}
