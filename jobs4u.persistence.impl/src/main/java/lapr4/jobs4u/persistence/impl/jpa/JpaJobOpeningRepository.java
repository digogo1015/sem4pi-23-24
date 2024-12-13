package lapr4.jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;

import java.util.*;

class JpaJobOpeningRepository
        extends JpaAutoTxRepository<JobOpening, JobReference, JobReference>
        implements JobOpeningRepository {

    public JpaJobOpeningRepository(final TransactionalContext autoTx) {
        super(autoTx, "jobReference");
    }

    public JpaJobOpeningRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "jobReference");
    }

    @Override
    public Optional<JobOpening> findByJobReference(final JobReference jobReference) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobReference", jobReference);
        return matchOne("e.identity=:designation", params);
    }

    @Override
    public List<JobOpening> allJobOpeningsWithRequirementsSpecification() {
        final Map<String, Object> params = new HashMap<>();
        params.put("recruitmentProcess", "recruitmentProcess");
        return match("e.recruitmentProcess IS NOT NULL");
    }

    @Override
    public List<JobOpening> findCustomerJobOpeningsWithRecruitmentProcess(Customer customer) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", customer);
        return match("e.customer=: name AND e.recruitmentProcess IS NOT NULL", params);
    }


    @Override
    public List<JobOpening> allJobOpeningsWithInterviewInAnalysis() {

        return match("e.recruitmentProcess IS NOT NULL AND e.recruitmentProcess.hasInterview IS TRUE");
    }

    @Override
    public List<JobOpening> jobOpeningByCustomer(Customer customer) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", customer);
        return match("e.customer=:name", params);
    }
    @Override
    public List<JobOpening> jobOpeningByManager(SystemUser manager) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", manager);
        return match("e.manager=:name", params);
    }

}
