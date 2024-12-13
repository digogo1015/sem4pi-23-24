package lapr4.jobs4u.app.backoffice.console.presentation.application;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.applicationmanagement.application.Top20WordsController;
import lapr4.jobs4u.applicationmanagement.domain.Application;

import java.util.List;

public class Top20WordsUI extends AbstractUI {

    private final Top20WordsController controller = new Top20WordsController();

    @Override
    protected boolean doShow() {

        final List<Application> applications = controller.allApplications();

        Application applicationSelected;

        int cont = 1;
        for (final Application application : applications) {
            System.out.print(cont + ". ");
            System.out.println(application.toString());
            cont++;
        }
        final int option1 = Console.readInteger("\nSelect an Application: ");
        if (option1 == 0) {
            System.out.println("No Application selected");
        } else {
            try {
                applicationSelected = applications.get(option1 - 1);

                List<String> list = controller.getTop20Words(applicationSelected);

                if (list.isEmpty()){
                    System.out.println("Directory or its files are empty");
                }else {
                    for (String word: list) {
                        System.out.println(word);
                    }
                }

            } catch (Exception ex) {
                System.out.println(ex);
                System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
            }
        }

        return false;
    }

    @Override
    public String headline() {
        return "Top 20 Words in Candidate Files";
    }
}
