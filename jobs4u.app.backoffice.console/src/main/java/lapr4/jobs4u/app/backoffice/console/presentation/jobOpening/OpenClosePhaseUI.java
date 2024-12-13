package lapr4.jobs4u.app.backoffice.console.presentation.jobOpening;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.app.backoffice.console.presentation.customer.RegisterCustomerUI;
import lapr4.jobs4u.jobopeningmanagement.application.OpenPhasesController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


public class OpenClosePhaseUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterCustomerUI.class);

    private final OpenPhasesController openPhasesController = new OpenPhasesController();

    @Override
    protected boolean doShow() {
        try {
            List<JobOpening> jobOpenings = openPhasesController.getListOfJobOpenings();
            if (jobOpenings.isEmpty()) {
                System.out.println("No job openings available!");
                return false;
            }

            System.out.println("Job Openings:");
            for (int i = 0; i < jobOpenings.size(); i++) {
                System.out.println(i + 1 + " - " + jobOpenings.get(i).toStringWithActivePhase());
            }
            int option;
            do {
                option = Console.readInteger("Choose the job opening you want to open/close a phase: ");
            }while (option < 1 || option > jobOpenings.size());
            JobOpening jobOpening = jobOpenings.get(option - 1);

            if (!openPhasesController.checkIfHasRecruitmentProcess(jobOpening)){
                System.out.println("This job opening does not have a recruitment process defined yet!");
                return false;
            }

            if (openPhasesController.checkIfIsCompleted(jobOpening)){
                System.out.println("This job opening is already completed!");
                return false;
            }


            boolean hasPhase = openPhasesController.checkIfHasActivePhase(jobOpening);
            if (!hasPhase){
                System.out.println("No active phase for this job opening.");
                System.out.println("Do you want to open the first phase?");

            }else {
                boolean isPossible = openPhasesController.checkIfIsPossibleToOpenNextPhase(jobOpening);
                System.out.println("Current Phase: " + openPhasesController.showJobOpeningCurrentPhase(jobOpening).getName());
                if (isPossible){
                    System.out.println("Do you want to open the next phase?");
                }else{
                    System.out.println("It is not possible to open the next phase.");
                    return true;
                }

            }


            String answer = Console.readLine("y/n: ");
            if (answer.equalsIgnoreCase("y")) {
                boolean flag = openPhasesController.openNextPhase(jobOpening);
                if (flag) System.out.println("Phase opened successfully!");
                System.out.println(jobOpening.phaseToString());
            } else if (answer.equalsIgnoreCase("n")){
                return true;
            }else {
                System.out.println("Invalid option!");
                return false;
            }

            return true;


        }catch (Exception e){
            LOGGER.error(e.getMessage());
        }

        return true;
    }

    @Override
    public String headline() {
        return "Open or Close a phase of Job Opening";
    }
}
