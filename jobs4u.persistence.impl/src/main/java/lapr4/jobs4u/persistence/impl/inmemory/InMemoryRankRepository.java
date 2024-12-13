package lapr4.jobs4u.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.rankmanagement.domain.Ranking;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;

public class InMemoryRankRepository
        extends InMemoryDomainRepository<Ranking, JobReference>
        implements RankRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Ranking findByRankJobReference(JobReference jobReference) {
        return matchOne(e -> e.identity().equals(jobReference)).orElse(null);
    }
}
