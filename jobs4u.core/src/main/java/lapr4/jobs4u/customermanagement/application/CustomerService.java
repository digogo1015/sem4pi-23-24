package lapr4.jobs4u.customermanagement.application;

import eapli.framework.domain.events.DomainEvent;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;
import lapr4.jobs4u.customermanagement.events.NewUserForCustomerEvent;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.usermanagement.domain.UserBuilderHelper;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

public class CustomerService {
    private final UserRepository userRepository = PersistenceContext.repositories().users();
    private final EventPublisher dispatcher = InProcessPubSub.publisher();


    public void registerCustomer(final String customerCode, final String companyName, final String email,
                                 final String street, final String city, final String state,
                                 final String username, final String password) {

        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();

        userBuilder.withUsername(username).withPassword(password).withName(companyName, companyName)
                .withEmail(email).withRoles(UserRoles.CUSTOMER);

        final SystemUser newUser = userRepository.save(userBuilder.build());

        // notify interested parties
        final DomainEvent event = new NewUserForCustomerEvent(customerCode, newUser, street, city, state);
        dispatcher.publish(event);
    }

}
