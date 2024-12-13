package lapr4.jobs4u.applicationmanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

import java.util.Date;

public class ApplicationBuilder implements DomainFactory<Application> {

    private ApplicationId applicationId;
    private Date date;
    private String pathApplicationFolder;
    private Candidate candidate;
    private JobOpening jobOpening;

    public ApplicationBuilder withApplicationId(final ApplicationId applicationId){
        this.applicationId = applicationId;
        return this;
    }
    public ApplicationBuilder withDate(final Date date){
        this.date = date;
        return this;
    }

    public ApplicationBuilder withPathApplicationFolder(final String pathApplicationFolder){
        this.pathApplicationFolder = pathApplicationFolder;
        return this;
    }

    public ApplicationBuilder withCandidate(final Candidate candidate){
        this.candidate = candidate;
        return this;
    }
    public ApplicationBuilder withJobOpening(final JobOpening jobOpening){
        this.jobOpening = jobOpening;
        return this;
    }

    @Override
    public Application build() {
        try {
            return new Application(this.applicationId, this.date, this.pathApplicationFolder, this.candidate, this.jobOpening);
        } catch (IllegalAccessException e) {
            System.out.printf("Invalid Application\nTry again!\n");
        }
        return null;
    }
}
