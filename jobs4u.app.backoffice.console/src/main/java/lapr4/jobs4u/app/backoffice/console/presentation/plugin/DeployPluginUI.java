package lapr4.jobs4u.app.backoffice.console.presentation.plugin;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.pluginmanagement.application.DeployPluginController;
import lapr4.jobs4u.pluginmanagement.domain.PluginType;
import lapr4.jobs4u.pluginmanagement.domain.TypeOfSomething;

import java.util.List;

public class DeployPluginUI extends AbstractUI {

    private final DeployPluginController pluginController = new DeployPluginController();

    @Override
    protected boolean doShow() {

        final List<TypeOfSomething> pluginTypes = List.of(PluginType.pluginsTypes());

        int cont = 1;
        for (final TypeOfSomething pluginType : pluginTypes) {
            System.out.print(cont + ". ");
            System.out.println(pluginType.toString());
            cont++;
        }
        final int option = Console.readInteger("\nSelect a Plugin Type: ");
        if (option == 0) {
            System.out.println("No Plugin selected");
        } else {
            try {
                TypeOfSomething pluginType = pluginTypes.get(option - 1);
                final String designation = Console.readLine("Designation");
                final String description = Console.readLine("Description");

                String classPath = "lapr4.jobs4u.lprog.";
                String pluginFilePath = "jobs4u.core/src/main/java/lapr4/jobs4u/lprog/";
                String pluginTemplateFilePath = "jobs4u.core/src/main/java/lapr4/jobs4u/lprog/";


                if (pluginType == PluginType.INTERVIEW_MODEL) {
                    classPath += "interviewModels.IntModClass";
                    pluginFilePath += "interviewModels/interviewModelFiles/";
                    pluginTemplateFilePath = pluginFilePath;

                } else {
                    classPath += "requirementsSpecifications.ReqSpecClass";
                    pluginFilePath += "requirementsSpecifications/requirementsSpecificationFiles/";
                    pluginTemplateFilePath = pluginFilePath;
                }

                String fileName = Console.readLine("Name of the Plugin file: ") ;
                pluginFilePath += fileName + "Solution.txt";
                pluginTemplateFilePath += fileName + "Template.txt";


                pluginController.deployPlugin(designation, description, classPath, pluginType, pluginFilePath, pluginTemplateFilePath);

            } catch (Exception ex) {
                System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system administrator.");
            }
        }

        return false;
    }

    @Override
    public String headline() {
        return "Deploy a Plugin";
    }
}
