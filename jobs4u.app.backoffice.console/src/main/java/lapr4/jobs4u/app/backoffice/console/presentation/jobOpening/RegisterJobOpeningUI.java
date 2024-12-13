package lapr4.jobs4u.app.backoffice.console.presentation.jobOpening;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.app.backoffice.console.presentation.customer.RegisterCustomerUI;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.jobopeningmanagement.application.RegisterJobOpeningController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningContractType;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningModes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class RegisterJobOpeningUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterCustomerUI.class);

    private final RegisterJobOpeningController jobOpeningController = new RegisterJobOpeningController();

    @Override
    protected boolean doShow() {

        try {

            final List<String> modeList = List.of(JobOpeningModes.modeTypes());
            final List<String> contractTypeList = List.of(JobOpeningContractType.contractTypes());
            final List<Customer> customerList = StreamSupport.stream(jobOpeningController.listCustomers().spliterator(), false)
                    .collect(Collectors.toList());

            final String jobTitle = Console.readLine("Job Opening title");
            final String description = Console.readLine("Description");
            final String street = Console.readLine("Address:\nStreet");
            final String city = Console.readLine("City");
            final String state = Console.readLine("State");
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


            final int numberOfVacancies = Console.readInteger("Number of Vacancies");


            cont = 1;
            if (customerList.isEmpty()){
                System.out.println("No costumers available!");
                throw new IllegalArgumentException();
            }
            for (final Customer customer : customerList) {
                System.out.print(cont + ". ");
                System.out.println(customer);
                cont++;
            }
            final int customerOption = Console.readInteger("\nSelect a Customer");
            if (customerOption > contractTypeList.size() + 1 || customerOption == 0 ){
                throw new IllegalArgumentException();
            }
            Customer customer = customerList.get(customerOption - 1);

            boolean done = this.jobOpeningController.registerJobOpening(jobTitle, description, street, city, state, mode, contractType, numberOfVacancies,customer);
            if (done){System.out.println("Created successfully!");}

        }catch (Exception ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");        }

        return false;
    }

    @Override
    public String headline() {
        return "Register a Job Opening";
    }
}
