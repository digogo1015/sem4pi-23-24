package lapr4.jobs4u.pluginmanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationId;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.pluginmanagement.domain.PlugIn;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

import java.io.IOException;
import java.util.List;

public class UploadRequirementsAnswerFileController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final PluginService pluginService = new PluginService();
    private final ApplicationRepository applicationRepository = PersistenceContext.repositories().applications();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

    public List<JobOpening> allJobOpeningsWithRequirementsSpecification() {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.OPERATOR);
        return jobOpeningRepository.allJobOpeningsWithRequirementsSpecification();
    }

    public List<Application> applicationsOfJobOpening(JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.OPERATOR);
        return applicationRepository.applicationsOfJobOpening(jobOpening);
    }

    public List<ApplicationId> checkFiles(PlugIn plugin, List<Application> applications) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.OPERATOR);
        return pluginService.checkRequirementsFiles(plugin, applications);
    }
}
