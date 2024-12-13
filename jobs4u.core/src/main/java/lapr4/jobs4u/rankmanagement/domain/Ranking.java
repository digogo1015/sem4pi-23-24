package lapr4.jobs4u.rankmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import jakarta.persistence.*;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Entity
@Embeddable
public class Ranking implements AggregateRoot<JobReference> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @EmbeddedId
    private JobReference jobReference;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order1> ranking;

    public Ranking(final JobReference jobReference, final List<Order1> ranking) {
        if (jobReference == null || ranking == null|| ranking.isEmpty() )
            throw new IllegalArgumentException();
        this.jobReference = jobReference;
        this.ranking = ranking;
    }

    protected Ranking() { }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public JobReference jobReference() {
        return identity();
    }
    public List<Order1> ranking() {
        return ranking;
    }

    @Override
    public JobReference identity() {
        return this.jobReference;
    }


    @Override
    public String toString() {
        return  "Job Reference: " + jobReference +
                "\nRanking: " + ranking;
    }


    public void defineRanking(List<Order1> ranking) {
        this.ranking = ranking;
    }

    public void sortRankingByRank() {
            Collections.sort(ranking, Comparator.comparing(Order1::positionOfRanking));
        }
    
}
