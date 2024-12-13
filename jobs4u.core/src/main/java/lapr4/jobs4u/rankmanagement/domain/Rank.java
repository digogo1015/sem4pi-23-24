package lapr4.jobs4u.rankmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;


@Embeddable
public class Rank implements ValueObject, Comparable<Rank> {

    private static final long serialVersionUID = 1L;

    private Integer rank;

    public Rank(final Integer rank) {
        if(rank == null || rank <= 0)
            throw new IllegalArgumentException();

        this.rank = rank;
    }

    protected Rank() {}

    public static Rank valueOf(final Integer rank) {
        return new Rank(rank);
    }

    @Override
    public String toString() {
        return "" + rank;    }

    public Integer rank() {
        return rank;
    }

    @Override
    public int compareTo(Rank other) {
        return Integer.compare(this.rank, other.rank);
    }
}
