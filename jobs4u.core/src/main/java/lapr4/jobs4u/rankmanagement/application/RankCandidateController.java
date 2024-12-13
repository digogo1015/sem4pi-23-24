package lapr4.jobs4u.rankmanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.JobOpeningService;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.rankmanagement.domain.Order1;
import lapr4.jobs4u.rankmanagement.domain.Rank;
import lapr4.jobs4u.rankmanagement.domain.Ranking;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

import java.util.List;

public class RankCandidateController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningService jobOpeningService = new JobOpeningService();
    private final RankService rankService = new RankService();
    private final ApplicationRepository applicationRepository = PersistenceContext.repositories().applications();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final RankRepository rankRepository = PersistenceContext.repositories().ranks();


    public List<JobOpening> allJobOpeningsInAnalysis() {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.CUSTOMER_MANAGER);
        return jobOpeningService.allJobOpeningsInAnalysis(jobOpeningRepository.allJobOpeningsWithRequirementsSpecification());
    }

    public void saveRank(JobReference jobReference, List<Order1> ranking) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.CUSTOMER_MANAGER);
        Ranking r = new Ranking(jobReference, ranking);
        rankRepository.save(r);
    }

    public List<Application> applicationsOfJobOpening(JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.CUSTOMER_MANAGER);
        return applicationRepository.applicationsOfJobOpening(jobOpening);
    }

    public Order1 addRank(Application application, int rank) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.CUSTOMER_MANAGER);
        return new Order1(application, new Rank(rank));
    }

    public boolean checkIfRankExists(JobReference jobReference, List<Order1> ranking) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.CUSTOMER_MANAGER);
        boolean res = rankService.checkIfRankExists(jobReference, (List<Ranking>) rankRepository.findAll());

        if (!res)
            saveRank(jobReference, ranking);
        else
            editRank(jobReference, ranking);

        return res;
    }

    public void editRank(JobReference jobReference, List<Order1> ranking) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.CUSTOMER_MANAGER);
        rankService.saveRank(jobReference, ranking);
    }
}
