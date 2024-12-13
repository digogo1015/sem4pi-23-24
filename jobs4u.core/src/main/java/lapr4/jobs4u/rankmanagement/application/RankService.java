package lapr4.jobs4u.rankmanagement.application;

import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.rankmanagement.domain.Order1;
import lapr4.jobs4u.rankmanagement.domain.Ranking;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;

import java.util.List;


public class RankService {

    private final RankRepository rankRepository = PersistenceContext.repositories().ranks();

    public List<Ranking> allRanks() {
        return (List<Ranking>) this.rankRepository.findAll();
    }

    public void saveRank(JobReference jobReference, List<Order1> ranking) {
        Ranking rank = null;
        List<Ranking> ranks = allRanks();

        for (Ranking r : ranks) {
            if (r.jobReference().equals(jobReference))
                rank = r;
        }

        rankRepository.remove(rank);
        rank.defineRanking(ranking);
        rankRepository.save(rank);
    }

    public Ranking findByRankJobReference(JobReference jobReference) {
        List<Ranking> ranks = allRanks();

        for (Ranking r : ranks) {
            if (r.jobReference().equals(jobReference))
                return r;
        }
        return null;
    }


    public boolean checkIfAllCandidatesHaveBeenRanked(JobOpening jobOpening) {
        Ranking ranking = findByRankJobReference(jobOpening.reference());
        if (ranking == null) return false;
        return !ranking.ranking().isEmpty();
    }

    public boolean checkIfRankExists(JobReference jobReference, List<Ranking> jobOpeningsRanked) {
        for (Ranking rank : jobOpeningsRanked)
            if (rank.identity().equals(jobReference))
                return true;

        return false;
    }
}
