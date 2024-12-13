/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package lapr4.jobs4u.customermanagement.eventhandlers;

import eapli.framework.application.UseCaseController;
import eapli.framework.domain.events.DomainEvent;
import eapli.framework.functional.Functions;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerBuilder;
import lapr4.jobs4u.customermanagement.events.ErrorCreatingCustomerEvent;
import lapr4.jobs4u.customermanagement.events.NewUserForCustomerEvent;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;

import java.util.Optional;


@UseCaseController
        /* package */ class AddCustomerOnUserCreationController {
    private final UserRepository repo = PersistenceContext.repositories().users();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final EventPublisher dispatcher = InProcessPubSub.publisher();
    private final CustomerRepository customerRepository = PersistenceContext
            .repositories().customers();

    public void addCustomer(final NewUserForCustomerEvent event) {


        if (findUser(event)) {

            try {

                final CustomerBuilder customerBuilder = new CustomerBuilder();

                final Customer newCustomer = customerBuilder.withCustomerCode(event.customerCode()).withSystemUser
                        (event.user()).withAddress(event.street(), event.city(), event.state()).withManager
                        (authz.session().get().authenticatedUser()).build();
                customerRepository.save(newCustomer);


            } catch (Exception ex) {

                final DomainEvent error = new ErrorCreatingCustomerEvent(event.user());
                dispatcher.publish(error);

            }
        }


    }

    @SuppressWarnings("squid:S1488")
    private boolean findUser(final NewUserForCustomerEvent event) {
        // since we are using events, the actual user may not yet be
        // created, so lets give it a time and wait
        final Optional<SystemUser> newUser = Functions.retry(() ->
                repo.ofIdentity(event.user().username()), 1000, 3);
        return (newUser.isPresent());
    }
}
