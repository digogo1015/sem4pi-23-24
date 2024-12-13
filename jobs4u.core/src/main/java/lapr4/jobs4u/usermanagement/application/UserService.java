package lapr4.jobs4u.usermanagement.application;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import lapr4.jobs4u.usermanagement.domain.UserRoles;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final UserManagementService userSvc = AuthzRegistry.userService();

    public List<SystemUser> allUsers() {
        return (List<SystemUser>) userSvc.allUsers();
    }

    public List<SystemUser> backofficeUsers(List<SystemUser> users) {
        List<SystemUser> backofficeUsers = new ArrayList<>();
        for (SystemUser user : users) {
            if (!(user.roleTypes().contains(UserRoles.CUSTOMER) || user.roleTypes().contains(UserRoles.CANDIDATE))) {
                backofficeUsers.add(user);
            }
        }
        return backofficeUsers;
    }

}
