package lapr4.jobs4u.customermanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;

import java.util.Optional;

public interface CustomerRepository
        extends DomainRepository<CustomerCode, Customer> {

    Customer findByUsername(Username name);

    default Optional<Customer> findByCustomerCode(final CustomerCode code) {
        return ofIdentity(code);
    }

    Iterable<Customer> findAllActive();
}
