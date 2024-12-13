package lapr4.jobs4u.app.backoffice.console.presentation.application;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.applicationmanagement.application.ListApplicationByJobOpeningController;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ListApplicationByJobOpeningUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterApplicationUI.class);
    private final ListApplicationByJobOpeningController controller = new ListApplicationByJobOpeningController();

    @Override
    protected boolean doShow() {

        final List<JobOpening> jobOpeningList = controller.allJobOpenings();

        JobOpening jobOpening = null;

        int cont = 1;
        for (final JobOpening j : jobOpeningList) {
            System.out.print(cont + ". ");
            System.out.printf("REF: %s\n", j.identity());
            cont++;
        }

        final int option2 = Console.readInteger("\nSelect a JobOpening: ");
        if (option2 == 0) {
            System.out.println("No JobOpening selected");
        } else {
            try {
                jobOpening = jobOpeningList.get(option2 - 1);

            } catch (IntegrityViolationException | ConcurrencyException ex) {
                System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
            }
        }

        List<Application> list = controller.listApplicationByJobOpening(jobOpening);

        cont = 1;
        for (final Application a : list) {
            System.out.print(cont + ". ");
            System.out.printf("Application: %s\n", a.toString());
            cont++;
        }
        return false;
    }

    @Override
    public String headline() {
        return "ListApplicationByJobOpeningUI";
    }
}
