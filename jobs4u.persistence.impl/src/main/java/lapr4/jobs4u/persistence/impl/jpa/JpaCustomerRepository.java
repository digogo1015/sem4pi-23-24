package lapr4.jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class JpaCustomerRepository
        extends JpaAutoTxRepository<Customer, CustomerCode, CustomerCode>
        implements CustomerRepository {

    public JpaCustomerRepository(final TransactionalContext autoTx) {
        super(autoTx, "customerCode");
    }

    public JpaCustomerRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "customerCode");
    }

    @Override
    public Customer findByUsername(final Username name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return matchOne("e.systemUser.username=:name", params).orElse(null);
    }


    @Override
    public Optional<Customer> findByCustomerCode(final CustomerCode code) {
        final Map<String, Object> params = new HashMap<>();
        params.put("code", code);
        return matchOne("e.identity=:code", params);
    }

    @Override
    public Iterable<Customer> findAllActive() {
        return match("e.systemUser.active = true");
    }
}
