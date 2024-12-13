package lapr4.jobs4u.jobopeningmanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ListJobOpeningController {

    private static final Logger LOGGER = LogManager.getLogger(RegisterJobOpeningController.class);
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();



    public List<JobOpening> getListOfJobOpenings(){

        Iterable<JobOpening> jobOpenings = jobOpeningRepository.jobOpeningByManager(authz.session().get().authenticatedUser());

        List<JobOpening> jobOpeningList = StreamSupport.stream(jobOpenings.spliterator(), false)
                .collect(Collectors.toList());
        return jobOpeningList;

    }




}
