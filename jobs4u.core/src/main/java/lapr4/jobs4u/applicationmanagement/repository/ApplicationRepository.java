package lapr4.jobs4u.applicationmanagement.repository;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationId;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository
        extends DomainRepository<ApplicationId, Application> {

    default Optional<Application> findByApplicationId(final ApplicationId applicationId) {
        return ofIdentity(applicationId);
    }

    List<Application> findAllNotKnown(JobOpening jobOpening);

    List<Application> findAllWithFolderPath();

    List<Application> applicationsOfJobOpening(JobOpening jobOpening);


    List<Application> findAcceptedNonNotifiedApplications();

    List<Application> findApplicationsByCandidate(Candidate candidate);

    int countByJobOpening(JobOpening jobOpening);
}
