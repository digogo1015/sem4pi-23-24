package lapr4.jobs4u.pluginmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Designation;
import lapr4.jobs4u.pluginmanagement.domain.PlugIn;

import java.util.Optional;

public interface PluginRepository
        extends DomainRepository<Designation, PlugIn> {

    default Optional<PlugIn> findByDesignation(final Designation designation) {
        return ofIdentity(designation);
    }
}
