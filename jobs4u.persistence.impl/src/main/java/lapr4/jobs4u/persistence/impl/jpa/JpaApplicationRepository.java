package lapr4.jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationId;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class JpaApplicationRepository
        extends JpaAutoTxRepository<Application, ApplicationId, ApplicationId>
        implements ApplicationRepository {

    public JpaApplicationRepository(final TransactionalContext autoTx) {
        super(autoTx, "applicationId");
    }

    public JpaApplicationRepository(final String puname) {
        super(puname, lapr4.jobs4u.Application.settings().getExtendedPersistenceProperties(),
                "applicationId");
    }

    @Override
    public Optional<Application> findByApplicationId(final ApplicationId applicationId) {
        final Map<String, Object> params = new HashMap<>();
        params.put("applicationId", applicationId);
        return matchOne("e.identity=:applicationId", params);
    }

    @Override
    public List<Application> findAllNotKnown(JobOpening jobOpening) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", "NOT_KNOWN");
        params.put("jobOpening", jobOpening);
        return match("e.applicationState=: name AND e.jobOpening=: jobOpening",params);
    }

    @Override
    public List<Application> findAllWithFolderPath() {
        return match("e.pathApplicationFolder IS NOT NULL");
    }

    @Override
    public List<Application> applicationsOfJobOpening(JobOpening jobOpening) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobOpening", jobOpening);
        return match("e.jobOpening=: jobOpening",params);    }

    @Override
    public List<Application> findAcceptedNonNotifiedApplications() {
        final Map<String, Object> params = new HashMap<>();
        params.put("state", "ACCEPTED");
        return match("e.applicationState=: state AND e.emailResult IS FALSE",params);    }

    @Override
    public List<Application> findApplicationsByCandidate(Candidate candidate) {
        final Map<String, Object> params = new HashMap<>();
        params.put("candidate", candidate);
        return match("e.candidate=:candidate", params);
    }

    @Override
    public int countByJobOpening(JobOpening jobOpening) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobOpening", jobOpening);
        return match("e.jobOpening=:jobOpening", params).size();
    }

}
