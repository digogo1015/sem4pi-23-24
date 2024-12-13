package lapr4.jobs4u.app.backoffice.console.presentation.plugin;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.pluginmanagement.application.SelectRequirementsSpecificationController;
import lapr4.jobs4u.pluginmanagement.domain.PlugIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SelectRequirementsSpecificationUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelectRequirementsSpecificationUI.class);

    private final SelectRequirementsSpecificationController controller = new SelectRequirementsSpecificationController();

    @Override
    protected boolean doShow() {

        final List<JobOpening> jobOpenings = controller.allJobOpenings();

        JobOpening jobOpening = null;

        PlugIn requirementSpecification;

        int cont = 1;
        for (final JobOpening jobopening : jobOpenings) {
            System.out.print(cont + ". ");
            System.out.println(jobopening.toString());
            cont++;
        }
        final int option1 = Console.readInteger("\nSelect a Job Opening: ");
        if (option1 == 0) {
            System.out.println("No Job Opening selected");
        } else {
            try {
                jobOpening = jobOpenings.get(option1 - 1);

            } catch (Exception ex) {
                System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
            }
        }

        final List<PlugIn> requirements = controller.allRequirements();

        cont = 1;
        for (final PlugIn requirement : requirements) {
            System.out.print(cont + ". ");
            System.out.println(requirement.toString());
            cont++;
        }
        final int option = Console.readInteger("\nSelect a Requirements Specification: ");
        if (option == 0) {
            System.out.println("No Requirements Specification selected");
        } else {
            try {
                requirementSpecification = requirements.get(option - 1);
                if (jobOpening != null) {
                    controller.selectRequirementsSpecification(requirementSpecification, jobOpening);
                }

            } catch (Exception ex) {
                System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
            }
        }

        return false;
    }

    @Override
    public String headline() {
        return "Select a requirement";
    }
}
