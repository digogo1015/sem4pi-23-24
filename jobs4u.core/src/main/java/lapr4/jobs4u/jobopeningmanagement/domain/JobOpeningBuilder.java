package lapr4.jobs4u.jobopeningmanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.pluginmanagement.domain.PlugIn;


public class JobOpeningBuilder implements DomainFactory<JobOpening> {

    private JobReference reference;
    private Description description;
    private Address address;
    private String jobOpeningMode;
    private String jobTitle;
    private String jobOpeningState;
    private String contractType;
    private Integer numberOfVacancies;
    private RecruitmentProcess recruitmentProcess;
    private Customer customer;
    private SystemUser manager;
    private PlugIn InterviewModel;
    private PlugIn RequirementsSpecification;

    public JobOpeningBuilder withJobReference(final JobReference reference){
        this.reference = reference;
        return this;
    }

    public JobOpeningBuilder withDescription(final Description description){
        this.description = description;
        return this;
    }
    public JobOpeningBuilder withAddress(final String street, String city, String state){
        this.address = new Address(street,city,state);
        return this;
    }
    public JobOpeningBuilder withMode(final String mode){
        this.jobOpeningMode = mode;
        return this;
    }
    public JobOpeningBuilder withTitle(final String title){
        this.jobTitle = title;
        return this;
    }
    public JobOpeningBuilder withState(final String state){
        this.jobOpeningState = state;
        return this;
    }
    public JobOpeningBuilder withContractType(final String contractType){
        this.contractType = contractType;
        return this;
    }
    public JobOpeningBuilder withNumberOfVacancies(final Integer vacancies){
        this.numberOfVacancies = vacancies;
        return this;
    }

    public JobOpeningBuilder withManager(final SystemUser manager){
        this.manager = manager;
        return this;
    }

    public JobOpeningBuilder withCustomer(final Customer customer){
        this.customer = customer;
        return this;
    }


    @Override
    public JobOpening build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        return new JobOpening(this.reference,this.description,this.address,this.jobOpeningMode,this.jobTitle,
                this.jobOpeningState,this.contractType,this.numberOfVacancies,this.manager,this.customer);
    }
}
