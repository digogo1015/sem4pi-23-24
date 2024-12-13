/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package lapr4.jobs4u.infrastructure.bootstrapers.demo;

import java.util.HashSet;
import java.util.Set;

import lapr4.jobs4u.infrastructure.bootstrapers.AbstractUserBootstrapper;
import lapr4.jobs4u.infrastructure.bootstrapers.TestDataConstants;
import lapr4.jobs4u.usermanagement.domain.UserRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public class BackofficeUsersBootstrapper extends AbstractUserBootstrapper implements Action {

    @Override
    public boolean execute() {
        registerDefaultOperator(TestDataConstants.PASSWORD1, "Orisvaldo", "Silva", "operator@jobs4u.com");
        registerDefaultCustomerManager(TestDataConstants.PASSWORD1, "Dom", "Ermelindo", "cmanager@jobs4u.com");
        registerDefaultLanguageEngineer(TestDataConstants.PASSWORD1, "Dona", "Ermelinda", "lengineer@jobs4u.com");

        return true;
    }

    private void registerDefaultOperator(final String password, final String firstName,
                                         final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(UserRoles.OPERATOR);

        registerUser(password, firstName, lastName, email, roles);
    }

    private void registerDefaultCustomerManager( final String password, final String firstName,
                                                 final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(UserRoles.CUSTOMER_MANAGER);

        registerUser(password, firstName, lastName, email, roles);
    }

    private void registerDefaultLanguageEngineer(final String password, final String firstName,
                                                 final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(UserRoles.LANGUAGE_ENGINEER);

        registerUser(password, firstName, lastName, email, roles);
    }


}
