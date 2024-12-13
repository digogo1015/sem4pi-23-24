package lapr4.jobs4u.candidatemanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

@UseCaseController
public class DeactivateCandidateController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();
    private final UserManagementService userSvc = AuthzRegistry.userService();

    public Iterable<Candidate> allActiveUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.OPERATOR);

        return candidateRepository.findAllActive();
    }

    public void deactivateCandidate(final SystemUser user) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.OPERATOR);

        userSvc.deactivateUser(user);
    }


}
