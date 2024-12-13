package lapr4.jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.rankmanagement.domain.Ranking;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;

import java.util.HashMap;
import java.util.Map;

class JpaRankRepository
        extends JpaAutoTxRepository<Ranking, JobReference, JobReference>
        implements RankRepository {

    public JpaRankRepository(final TransactionalContext autoTx) {
        super(autoTx, "emailAddress");
    }

    public JpaRankRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "emailAddress");
    }

    @Override
    public Ranking findByRankJobReference(JobReference jobReference) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobReference", jobReference);
        return matchOne("e.jobReference=:jobReference", params).orElse(null);    }
}