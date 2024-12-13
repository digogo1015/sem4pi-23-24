package lapr4.jobs4u.usermanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

import java.util.List;


@UseCaseController
public class ListBackOfficeUsersController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserService userService = new UserService();
    private final UserManagementService userSvc = AuthzRegistry.userService();


    public Iterable<SystemUser> allBackOfficeUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN);
        return userService.backofficeUsers((List<SystemUser>) userSvc.allUsers());
    }
}
