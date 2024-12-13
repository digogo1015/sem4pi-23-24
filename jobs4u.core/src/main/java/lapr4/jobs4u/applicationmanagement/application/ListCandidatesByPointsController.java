package lapr4.jobs4u.applicationmanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.JobOpeningService;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

import java.util.List;

public class ListCandidatesByPointsController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningService jobOpeningService = new JobOpeningService();
    private final ApplicationService applicationService = new ApplicationService();
    private final ApplicationRepository applicationRepository = PersistenceContext.repositories().applications();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();


    public List<JobOpening> allJobOpeningsWithInterviewInAnalysis() {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.CUSTOMER_MANAGER);
        return jobOpeningService.allJobOpeningsWithInterviewInAnalysis(jobOpeningRepository.allJobOpeningsWithInterviewInAnalysis());
    }

    public List<Application> sortApplicationsByInterviewPoints(JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.CUSTOMER_MANAGER);
        return applicationService.sortApplicationsByInterviewPoints(applicationRepository.applicationsOfJobOpening(jobOpening));
    }

}
