package lapr4.jobs4u.candidatemanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

import java.util.List;

@UseCaseController
public class ShowCandidateInfoController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CandidateService candidateService = new CandidateService();
    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();

    public List<Candidate> allActiveUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.CUSTOMER_MANAGER);
        return candidateService.sortUserAlphabetically((List<Candidate>) candidateRepository.findAllActive());
    }

}
