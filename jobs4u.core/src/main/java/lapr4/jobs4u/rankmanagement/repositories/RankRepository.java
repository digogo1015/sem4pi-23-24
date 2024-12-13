package lapr4.jobs4u.rankmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.rankmanagement.domain.Ranking;

public interface RankRepository
        extends DomainRepository<JobReference, Ranking> {

     Ranking findByRankJobReference(final JobReference jobReference);

}
