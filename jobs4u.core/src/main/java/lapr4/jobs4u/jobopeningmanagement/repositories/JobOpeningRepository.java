
package lapr4.jobs4u.jobopeningmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;

import java.util.List;
import java.util.Optional;

public interface JobOpeningRepository
        extends DomainRepository<JobReference, JobOpening> {

    default Optional<JobOpening> findByJobReference(final JobReference reference) {
        return ofIdentity(reference);
    }

    List<JobOpening> jobOpeningByCustomer(Customer customer);
    List<JobOpening> jobOpeningByManager(SystemUser manager);


    List<JobOpening> findCustomerJobOpeningsWithRecruitmentProcess(Customer customer);

    List<JobOpening> allJobOpeningsWithInterviewInAnalysis();

    List<JobOpening> allJobOpeningsWithRequirementsSpecification();


}
