package lapr4.jobs4u.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationId;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationStates;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class InMemoryApplicationRepository
        extends InMemoryDomainRepository<Application, ApplicationId>
        implements ApplicationRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Application> findByApplicationId(final ApplicationId applicationId) {
        return Optional.of(data().get(applicationId));
    }

    @Override
    public List<Application> findAllNotKnown(JobOpening jobOpening) {
        return (List<Application>) match(e -> e.isNotKnown() && e.jobOpening().equals(jobOpening));
    }

    @Override
    public List<Application> findAllWithFolderPath() {
        return (List<Application>) match(e -> e.pathApplicationFolder() != null);
    }

    @Override
    public List<Application> applicationsOfJobOpening(JobOpening jobOpening) {
        return (List<Application>) match(e -> e.jobOpening().equals(jobOpening));
    }

    @Override
    public List<Application> findAcceptedNonNotifiedApplications() {
        return (List<Application>) match(e -> e.emailSent() && e.applicationState().equals(ApplicationStates.ACCEPTED));
    }

    @Override
    public List<Application> findApplicationsByCandidate(Candidate candidate) {
        return StreamSupport.stream(match(e -> e.candidate().equals(candidate)).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public int countByJobOpening(JobOpening jobOpening) {
        return (int) StreamSupport.stream(match(e -> e.jobOpening().equals(jobOpening)).spliterator(), false)
                .count();
    }

}
