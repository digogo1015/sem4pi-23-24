package lapr4.jobs4u.applicationmanagement.application;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationBuilder;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationId;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.RegisterJobOpeningController;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

public class RegisterApplicationController {
    private static final Logger LOGGER = LogManager.getLogger(RegisterJobOpeningController.class);

    private final ApplicationRepository repository = PersistenceContext.repositories().applications();

    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();

    public void registerApplication(ApplicationId applicationId, Date date, String pathApplicationFolder,
                                    Candidate candidate, JobOpening jobOpening) {

        final ApplicationBuilder applicationBuilder = new ApplicationBuilder();

        try {
            final Application application = applicationBuilder.withApplicationId(applicationId)
                    .withDate(date)
                    .withPathApplicationFolder(pathApplicationFolder)
                    .withCandidate(candidate)
                    .withJobOpening(jobOpening)
                    .build();

            repository.save(application);
        } catch (Exception ex) {
            LOGGER.error("APPLICATION BUILD ERROR", ex);
        }
    }

    public List<JobOpening> allJobOpenings() {
        return (List<JobOpening>) jobOpeningRepository.findAll();
    }


    public List<Candidate> allCandidates() {
        return (List<Candidate>) candidateRepository.findAll();
    }
}
