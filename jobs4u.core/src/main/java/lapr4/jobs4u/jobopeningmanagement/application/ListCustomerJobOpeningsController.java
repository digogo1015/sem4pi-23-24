package lapr4.jobs4u.jobopeningmanagement.application;

import eapli.framework.infrastructure.authz.domain.model.Username;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;

import java.util.List;

public class ListCustomerJobOpeningsController {
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private final JobOpeningService jobOpeningService = new JobOpeningService();

    public List<JobOpeningDTO> allCustomerJobOpeningsWithRecruitmentProcess(String username) {

        Customer customer = customerRepository.findByUsername(Username.valueOf(username));

        return jobOpeningService.allCustomerJobOpeningsWithRecruitmentProcess(customer);
    }

}
