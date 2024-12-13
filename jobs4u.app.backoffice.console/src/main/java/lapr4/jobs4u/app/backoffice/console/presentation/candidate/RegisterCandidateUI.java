package lapr4.jobs4u.app.backoffice.console.presentation.candidate;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.candidatemanagement.application.RegisterCandidateController;
import lapr4.jobs4u.usermanagement.domain.UserPasswordPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterCandidateUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterCandidateUI.class);

    private final RegisterCandidateController candidateController = new RegisterCandidateController();

    @Override
    protected boolean doShow() {
        headline();

        final String firstName = Console.readLine("First Name");
        final String lastName = Console.readLine("Last Name");
        final String phoneNumber = Console.readLine("Phone Number");
        final String email = Console.readLine("E-Mail");
        final String password = UserPasswordPolicy.generatePassword();

        try {
            this.candidateController.registerCandidate(firstName, lastName, phoneNumber, email, email, password);
            System.out.println("\nFirst Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password + "\n");

            System.out.print("Operating Success\n");

        } catch (Exception ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "\nRegister a Candidate\n";
    }
}
