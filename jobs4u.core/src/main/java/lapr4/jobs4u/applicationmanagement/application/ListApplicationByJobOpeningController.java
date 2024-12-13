package lapr4.jobs4u.applicationmanagement.application;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ListApplicationByJobOpeningController {
    private static final Logger LOGGER = LogManager.getLogger(ListApplicationByJobOpeningController.class);

    private final ApplicationRepository repository = PersistenceContext.repositories().applications();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

    public List<Application> listApplicationByJobOpening(JobOpening jobOpening)
    {
        List<Application> list = (List<Application>) repository.findAll();
        List<Application> returnList = new ArrayList<>();

        for (Application a: list)
            if (a.jobOpening().equals(jobOpening))
                returnList.add(a);
        return returnList;
    }

    public List<JobOpening> allJobOpenings() {
        return (List<JobOpening>) jobOpeningRepository.findAll();
    }
}
