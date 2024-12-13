package lapr4.jobs4u.app.backoffice.console.presentation.jobOpening;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.app.backoffice.console.presentation.customer.RegisterCustomerUI;
import lapr4.jobs4u.jobopeningmanagement.application.EditJobOpeningController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningContractType;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningModes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class EditJobOpeningUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterCustomerUI.class);

    private final EditJobOpeningController editJobOpeningController = new EditJobOpeningController();
    final List<String> modeList = List.of(JobOpeningModes.modeTypes());
    final List<String> contractTypeList = List.of(JobOpeningContractType.contractTypes());

    @Override
    protected boolean doShow() {
        try {

            List<JobOpening> jobOpenings = editJobOpeningController.getListOfJobOpenings();
            if (jobOpenings.isEmpty()) {
                System.out.println("No job openings available!");
                return false;
            }

            System.out.println("Job Openings:");
            for (int i = 0; i < jobOpenings.size(); i++) {
                System.out.println(i + 1 + " - " + jobOpenings.get(i).toStringWithActivePhase());
            }
            System.out.println("0 - Return");
            int option;
            do {
                option = Console.readInteger("Choose the job opening you want to edit: ");
            }while (option < 0 || option > jobOpenings.size());
            if (option == 0) return false;
            JobOpening jobOpening = jobOpenings.get(option - 1);



            List<String> editableFields = editJobOpeningController.getEditableFields();
            for (int i = 0; i < editableFields.size(); i++) {
                System.out.println(i + 1 + " - " + editableFields.get(i));
            }
            System.out.println("0 - Return");
            do {
                option = Console.readInteger("Choose the field you want to edit: ");
            } while (option < 0 || option > editableFields.size());
            if (option == 0) return false;
            String field = editableFields.get(option - 1);
            String newValue;


            boolean flag = false;

            switch (field) {
                case "jobTitle":
                    newValue = Console.readLine("Enter the new value for " + field + ": ");
                    flag = editJobOpeningController.editJobTitle(jobOpening, newValue);
                    break;
                case "description":
                    newValue = Console.readLine("Enter the new value for " + field + ": ");
                    flag = editJobOpeningController.editDescription(jobOpening, newValue);
                    break;
                case "address":
                    final String street = Console.readLine("Address:\nStreet");
                    final String city = Console.readLine("City");
                    final String state = Console.readLine("State");
                    flag = editJobOpeningController.editAddress(jobOpening, street, city, state);
                    break;
                case "jobOpeningMode":
                    int cont = 1;
                    for (final String mode : modeList) {
                        System.out.print(cont + ". ");
                        System.out.println(mode);
                        cont++;
                    }
                    final int modeOption = Console.readInteger("Mode");
                    if (modeOption > modeList.size() || modeOption == 0 ){
                        throw new IllegalArgumentException();
                    }
                    String mode = modeList.get(modeOption - 1);
                    flag = editJobOpeningController.editJobOpeningMode(jobOpening, mode);
                    break;
                case "contractType":
                    cont = 1;
                    for (final String contract : contractTypeList) {
                        System.out.print(cont + ". ");
                        System.out.println(contract);
                        cont++;
                    }
                    final int contractTypeOption = Console.readInteger("ContractType");
                    if (contractTypeOption > contractTypeList.size() || contractTypeOption == 0 ){
                        throw new IllegalArgumentException();
                    }
                    String contractType = contractTypeList.get(contractTypeOption - 1);
                    flag = editJobOpeningController.editContractType(jobOpening, contractType);
                    break;
                case "numberOfVacancies":
                    final int numberOfVacancies = Console.readInteger("Number of Vacancies");
                    flag = editJobOpeningController.editNumberOfVacancies(jobOpening, numberOfVacancies);
                    break;
            }

            if (flag){
                System.out.println("Job Opening edited successfully!");
            } else {
                System.out.println("Error editing job opening!");
            }

            return flag;


        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return true;
    }

    @Override
    public String headline() {
        return "Edit a Job Opening";
    }
}
