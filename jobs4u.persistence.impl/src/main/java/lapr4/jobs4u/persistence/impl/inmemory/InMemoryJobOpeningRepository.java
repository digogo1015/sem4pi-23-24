package lapr4.jobs4u.persistence.impl.inmemory;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;

import java.util.List;
import java.util.Optional;

public class InMemoryJobOpeningRepository
        extends InMemoryDomainRepository<JobOpening, JobReference>
        implements JobOpeningRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<JobOpening> findByJobReference(final JobReference jobReference) {
        return Optional.of(data().get(jobReference));
    }

    @Override
    public List<JobOpening> findCustomerJobOpeningsWithRecruitmentProcess(Customer customer) {
        return (List<JobOpening>) match(e -> e.customer() == customer && e.recruitmentProcess() != null);
    }

    @Override
    public List<JobOpening> allJobOpeningsWithRequirementsSpecification() {
        return (List<JobOpening>) match(e -> e.recruitmentProcess() != null);
    }


    @Override
    public List<JobOpening> allJobOpeningsWithInterviewInAnalysis() {
        return (List<JobOpening>) match(e -> e.recruitmentProcess() != null && e.recruitmentProcess().isHasInterview());
    }

    @Override
    public List<JobOpening> jobOpeningByCustomer(Customer customer) {
        return (List<JobOpening>) match(e -> e.customer() == customer);
    }
    @Override
    public List<JobOpening> jobOpeningByManager(SystemUser manager) {
        return (List<JobOpening>) match(e -> e.manager() == manager);
    }

}
