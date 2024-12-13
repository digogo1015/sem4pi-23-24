package lapr4.jobs4u.candidatemanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

public class RegisterCandidateController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CandidateService candidateService = new CandidateService();


    public void registerCandidate(final String firstName, final String lastName, final String phoneNumber,
                                  final String emailAddress, final String username, final String password) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.OPERATOR);

        candidateService.registerCandidate(firstName, lastName, phoneNumber, emailAddress, username, password);
    }
}
