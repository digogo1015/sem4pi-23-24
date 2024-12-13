package lapr4.jobs4u.jobopeningmanagement.application;

import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningBuilder;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningStates;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegisterJobOpeningController{

    private static final Logger LOGGER = LogManager.getLogger(RegisterJobOpeningController.class);
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningService jobOpeningService = new JobOpeningService();

    public boolean registerJobOpening(final String jobTitle, final String description, final String street,final String city,
                                   final String state, final String jobOpeningMode, final String contractType,
                                   final Integer numberOfVacancies, final Customer customer) {

        final JobOpeningBuilder jobOpeningBuilder = new JobOpeningBuilder();

        try {

            String numberAfter = jobOpeningService.numberOfJobOpeningsByCustomer(customer) ;


            final JobOpening jobOpening = jobOpeningBuilder.withJobReference(new JobReference(customer.customerCode().toString(),numberAfter))
                    .withDescription(Description.valueOf(description)).withAddress(street,city,state)
                    .withMode(jobOpeningMode).withTitle(jobTitle).withState(JobOpeningStates.UNCOMPLETED).withContractType(contractType)
                    .withNumberOfVacancies(numberOfVacancies).withManager(authz.session().get().authenticatedUser()).withCustomer(customer).build();

            jobOpeningRepository.save(jobOpening);

        } catch (Exception ex) {
            LOGGER.error("ERRO", ex);
        }

        return true;
    }

    public  Iterable<Customer> listCustomers(){
        return customerRepository.findAllActive();
    }

}
