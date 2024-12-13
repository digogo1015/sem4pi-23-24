package lapr4.jobs4u.pluginmanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.pluginmanagement.domain.PlugIn;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

import java.io.IOException;
import java.util.List;

public class GenerateRequirementsTemplateController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final PluginService pluginService = new PluginService();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final ApplicationRepository applicationRepository = PersistenceContext.repositories().applications();

    public List<JobOpening> allJobOpeningsWithRequirementsSpecification() {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.OPERATOR);
        return jobOpeningRepository.allJobOpeningsWithRequirementsSpecification();
    }

    public void generateTemplate(PlugIn plugin, JobReference jobReference, List<Application> applications) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.OPERATOR);

        for (Application application : applications) {
            application.definePathApplicationAnswerFile(pluginService.generateTemplate(plugin, jobReference, application));
            applicationRepository.save(application);
        }
    }

    public List<Application> applicationsOfJobOpening(JobOpening jobOpening) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.OPERATOR);
        return applicationRepository.applicationsOfJobOpening(jobOpening);
    }
}
