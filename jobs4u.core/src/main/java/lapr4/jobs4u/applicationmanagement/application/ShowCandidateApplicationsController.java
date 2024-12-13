package lapr4.jobs4u.applicationmanagement.application;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ShowCandidateApplicationsController {
    private static final Logger LOGGER = LogManager.getLogger(ShowCandidateApplicationsController.class);

    private final ApplicationRepository repository = PersistenceContext.repositories().applications();
    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();

    public List<Application> showCandidateApplications(Candidate candidate)
    {
        List<Application> list = (List<Application>) repository.findAll();
        List<Application> returnList = new ArrayList<>();

        for (Application a: list)
            if (a.candidate().equals(candidate))
                returnList.add(a);
        return returnList;
    }

    public List<Candidate> allCandidates() {
        return (List<Candidate>) candidateRepository.findAll();
    }
}
