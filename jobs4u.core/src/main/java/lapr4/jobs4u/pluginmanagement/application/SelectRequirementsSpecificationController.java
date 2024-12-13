package lapr4.jobs4u.pluginmanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.pluginmanagement.domain.PlugIn;
import lapr4.jobs4u.pluginmanagement.domain.PluginType;
import lapr4.jobs4u.pluginmanagement.repositories.PluginRepository;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

import java.util.ArrayList;
import java.util.List;

@UseCaseController
public class SelectRequirementsSpecificationController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final PluginRepository repository = PersistenceContext.repositories().plugins();

    private final JobOpeningRepository repo = PersistenceContext.repositories().jobOpenings();

    public List<PlugIn> allRequirements() {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);

        Iterable<PlugIn> allPlugins = repository.findAll();

        List<PlugIn> requirements = new ArrayList<>();

        for (PlugIn plugIn : allPlugins) {

            if (plugIn.pluginType().equals(PluginType.REQUIREMENTS_SPECIFICATION)) {
                requirements.add(plugIn);
            }
        }

        return requirements;
    }

    public List<JobOpening> allJobOpenings() {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);

        Iterable<JobOpening> allJobOpenings = repo.findAll();

        List<JobOpening> jobOpenings = new ArrayList<>();

        for (JobOpening jobOpening : allJobOpenings) {

            if (jobOpening.requirementsSpecification() == null) {
                jobOpenings.add(jobOpening);
            }
        }

        return jobOpenings;
    }

    public void selectRequirementsSpecification(final PlugIn plugIn, final JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);
        jobOpening.RequirementSpecificationSelected(plugIn);
        repo.save(jobOpening);
    }

}