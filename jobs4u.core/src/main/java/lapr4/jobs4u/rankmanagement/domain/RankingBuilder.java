package lapr4.jobs4u.rankmanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;

import java.util.List;

public class RankingBuilder implements DomainFactory<Ranking> {

    private JobReference jobReference;
    private List<Order1> ranking;

    public RankingBuilder withJobReference(final JobReference jobReference) {
        this.jobReference = jobReference;
        return this;
    }

    public RankingBuilder withRanking(final List<Order1> ranking) {
        this.ranking = ranking;
        return this;
    }

    @Override
    public Ranking build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        return new Ranking(this.jobReference, this.ranking);
    }
}
