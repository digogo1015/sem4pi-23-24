package lapr4.jobs4u.customermanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

public class RegisterCustomerController {
    private final CustomerService customerService = new CustomerService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public void registerCustomer(final String customerCode, final String companyName, final String email,
                                 final String street, final String city, final String state,
                                 final String username, final String password) {

        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);

        customerService.registerCustomer(customerCode, companyName, email, street, city, state, username, password);

    }

}
