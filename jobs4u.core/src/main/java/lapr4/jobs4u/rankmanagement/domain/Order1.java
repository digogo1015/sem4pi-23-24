package lapr4.jobs4u.rankmanagement.domain;

import jakarta.persistence.*;
import lapr4.jobs4u.applicationmanagement.domain.Application;

import java.util.Objects;


@Entity
public class Order1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Application application;
    @Embedded
    private Rank rank;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order1 order1 = (Order1) o;
        return Objects.equals(id, order1.id) && Objects.equals(application, order1.application) && Objects.equals(rank, order1.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, application, rank);
    }

    public Order1(Application application, Rank rank) {
        if(rank == null || application == null)
            throw new IllegalArgumentException();
        this.application = application;
        this.rank = rank;
    }

    public Order1() {
    }

    public Application applicationOfRank() {
        return application;
    }

    public Rank positionOfRanking() {
        return rank;
    }
}
