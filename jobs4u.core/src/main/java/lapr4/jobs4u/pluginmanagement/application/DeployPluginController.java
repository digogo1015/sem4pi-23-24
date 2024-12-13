package lapr4.jobs4u.pluginmanagement.application;

import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.pluginmanagement.domain.*;
import lapr4.jobs4u.pluginmanagement.repositories.PluginRepository;
import lapr4.jobs4u.usermanagement.domain.UserRoles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeployPluginController {

    private static final Logger LOGGER = LogManager.getLogger(DeployPluginController.class);
    private final PluginRepository repository = PersistenceContext.repositories().plugins();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    public void deployPlugin(final String designation, final String description, final String classPath, final TypeOfSomething pluginType, final String pluginPath, final String pluginPathTemplate) {

        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.LANGUAGE_ENGINEER);

        final PluginBuilder pluginBuilder = new PluginBuilder();

        try {
            final PlugIn newPlugin = pluginBuilder.withDesignation(Designation.valueOf(designation)).
                    withDescription(Description.valueOf(description)).withClass(FQClassName.valueOf(classPath))
                    .withType(pluginType).withPath(pluginPath).withTemplatePath(pluginPathTemplate).build();

            final var importer = newPlugin.buildImporter();
            final boolean valid = (importer.checkPlugin(pluginPath) && importer.checkPlugin(pluginPathTemplate));

            if (valid) {
                repository.save(newPlugin);
            }

        } catch (Exception ex) {
            LOGGER.error("Unable to load the Plugin", ex);
        }

    }

}
