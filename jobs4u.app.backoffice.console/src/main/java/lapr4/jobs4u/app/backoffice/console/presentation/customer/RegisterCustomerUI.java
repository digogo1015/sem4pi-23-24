package lapr4.jobs4u.app.backoffice.console.presentation.customer;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.customermanagement.application.RegisterCustomerController;
import lapr4.jobs4u.usermanagement.domain.UserPasswordPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterCustomerUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterCustomerUI.class);

    private final RegisterCustomerController customerController = new RegisterCustomerController();

    @Override
    protected boolean doShow() {
        final String companyName = Console.readLine("Company Name");
        final String customerCode = Console.readLine("Customer Code");
        final String email = Console.readLine("E-Mail");
        final String street = Console.readLine("Address:\nStreet");
        final String city = Console.readLine("City");
        final String state = Console.readLine("State");
        final String password = UserPasswordPolicy.generatePassword();


        try {

            this.customerController.registerCustomer(customerCode, companyName, email, street, city, state, email, password);

        } catch (Exception ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
        }

        System.out.println("\nCustomer Successfully Registered");
        System.out.printf("#  %-25s%-20s%-20s%n", "Customer Code", "Company Name", "Email");
        System.out.printf("#  %-25s%-20s%-20s\n\n", customerCode, companyName, email);

        return false;
    }

    @Override
    public String headline() {
        return "Register a Customer";
    }
}
