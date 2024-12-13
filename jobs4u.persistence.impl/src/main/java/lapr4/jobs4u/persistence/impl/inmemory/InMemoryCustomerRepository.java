package lapr4.jobs4u.persistence.impl.inmemory;

import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;

import java.util.Optional;

public class InMemoryCustomerRepository
        extends InMemoryDomainRepository<Customer, CustomerCode>
        implements CustomerRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Customer findByUsername(final Username name) {
        return matchOne(e -> e.user().username().equals(name)).orElse(null);
    }

    @Override
    public Optional<Customer> findByCustomerCode(final CustomerCode code) {
        return Optional.of(data().get(code));
    }

    @Override
    public Iterable<Customer> findAllActive() {
        return match(e -> e.user().isActive());
    }
}
