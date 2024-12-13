package lapr4.jobs4u.applicationmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import jakarta.persistence.*;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.rankmanagement.domain.Ranking;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

@Entity
public class Application implements AggregateRoot<ApplicationId> {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LogManager.getLogger(Application.class);

    @Version
    private Long version;

    @EmbeddedId
    private ApplicationId applicationId;
    private Date date;
    private String applicationState;
    @Column(name = "EmailSent")
    private boolean emailResult;

    @OneToOne
    private Ranking rank;
    @Embedded
    private ApplicationInterview interview;
    private String pathApplicationFolder;
    private String pathApplicationAnswerFile;
    private String screeningResult;

    @ManyToOne
    private Candidate candidate;

    @ManyToOne
    private JobOpening jobOpening;

    public Application(ApplicationId applicationId, Date date, String pathApplicationFolder, Candidate candidate, JobOpening jobOpening) throws IllegalAccessException {
        if (applicationId == null || date == null || pathApplicationFolder == null || candidate == null)
            throw new IllegalAccessException();

        this.applicationId = applicationId;
        this.date = date;
        this.applicationState = ApplicationStates.NOT_KNOWN;
        this.emailResult = false;
        this.pathApplicationFolder = pathApplicationFolder;
        this.pathApplicationAnswerFile = null;
        this.screeningResult = null;
        this.candidate = candidate;
        this.jobOpening = jobOpening;

        if (jobOpening.recruitmentProcess() != null && jobOpening.recruitmentProcess().isHasInterview())
            this.interview = new ApplicationInterview(InterviewStatus.NOT_REALIZED);

    }

    protected Application() {
    }

    public JobOpening jobOpening() {
        return this.jobOpening;
    }

    public Candidate candidate() {
        return this.candidate;
    }

    public ApplicationInterview interview() {
        return this.interview;
    }

    public String applicationState() {
        return this.applicationState;
    }

    public void defineApplicationState(String applicationState) {
        this.applicationState = applicationState;
    }

    public boolean emailSent() {
        return this.emailResult;
    }

    public void defineEmailResult(boolean emailResult) {
        this.emailResult = emailResult;
    }

    public String pathApplicationFolder() {
        return pathApplicationFolder;
    }

    public String pathApplicationAnswerFile() {
        return pathApplicationAnswerFile;
    }

    public boolean isNotKnown() {
        return applicationState.equals(ApplicationStates.NOT_KNOWN);
    }
    public boolean hasScreeningResult(){
        return screeningResult!=null;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public ApplicationId applicationId() {
        return identity();
    }

    @Override
    public ApplicationId identity() {
        return this.applicationId;
    }

    public void definePathApplicationAnswerFile(String pathApplicationAnswerFile) {
        this.pathApplicationAnswerFile = pathApplicationAnswerFile;
    }

    @Override
    public String toString() {
        return "ApplicationId: " + applicationId +
                ", Date: " + date +
                ", Candidate: " + candidate +
                ", JobOpening: " + jobOpening;
    }

    public boolean hasInterview() {
        return interview != null;
    }

}
