package lapr4.jobs4u.applicationmanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.scomp.US4000.US4000;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

import java.util.List;

public class Top20WordsController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ApplicationRepository applicationRepository = PersistenceContext.repositories().applications();

    public List<Application> allApplications() {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.CUSTOMER_MANAGER);
        return (List<Application>) applicationRepository.findAllWithFolderPath();
    }

    public List<String> getTop20Words(Application application) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.CUSTOMER_MANAGER);
        return US4000.CountWords(application.pathApplicationFolder());
    }

}
