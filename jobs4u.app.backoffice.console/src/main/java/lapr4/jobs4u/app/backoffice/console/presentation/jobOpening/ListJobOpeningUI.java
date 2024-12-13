package lapr4.jobs4u.app.backoffice.console.presentation.jobOpening;

import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.app.backoffice.console.presentation.customer.RegisterCustomerUI;
import lapr4.jobs4u.jobopeningmanagement.application.ListJobOpeningController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ListJobOpeningUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterCustomerUI.class);

    private final ListJobOpeningController listJobOpeningController = new ListJobOpeningController();

    @Override
    protected boolean doShow() {

        try {

            List<JobOpening> listOfJobOpenings = listJobOpeningController.getListOfJobOpenings();
            int cont = 1;
            if (listOfJobOpenings.isEmpty()) {
                System.out.println("No costumers available!");
                throw new IllegalArgumentException();
            }
            for (JobOpening jobOpening : listOfJobOpenings) {
                System.out.print(cont + ". ");
                System.out.println(jobOpening);
                cont++;
            }

        } catch (Exception ex) {
            LOGGER.error("Error performing the operation", ex);
            System.out.println(
                    "Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "List a Job Opening";
    }


}
