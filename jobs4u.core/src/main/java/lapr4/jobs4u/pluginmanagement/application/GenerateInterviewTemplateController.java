package lapr4.jobs4u.pluginmanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.JobOpeningService;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.pluginmanagement.domain.PlugIn;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

import java.io.IOException;
import java.util.List;

public class GenerateInterviewTemplateController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final PluginService pluginService = new PluginService();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final ApplicationRepository applicationRepository = PersistenceContext.repositories().applications();
    private final JobOpeningService jobOpeningService = new JobOpeningService();

    public List<JobOpening> allJobOpeningsWithInterviewInAnalysis() {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);
        return jobOpeningService.allJobOpeningsWithInterviewInAnalysis(jobOpeningRepository.allJobOpeningsWithInterviewInAnalysis());
    }

    public void generateTemplate(PlugIn plugin, JobReference jobReference, List<Application> applications) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);

        for (Application application : applications) {
            application.interview().defineInterviewAnswerPath(pluginService.generateTemplate(plugin, jobReference, application));
            applicationRepository.save(application);
        }
    }

    public List<Application> applicationsOfJobOpening(JobOpening jobOpening) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);
        return applicationRepository.applicationsOfJobOpening(jobOpening);
    }
}
