package lapr4.jobs4u.applicationmanagement.application;

import lapr4.jobs4u.applicationmanagement.domain.ApplicationId;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationStates;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;

import java.io.Serializable;
import java.util.Date;

public class ApplicationDTO implements Serializable {

    private final ApplicationId id;
    private final String state;
    private final Date date;
    private final Candidate candidateName;
    private final String jobOpeningTitle;
    private final int numberOfApplicants;

    public ApplicationDTO(ApplicationId id, String state, Date date, Candidate candidateName, String jobOpeningTitle, int numberOfApplicants) {
        if (!isValidState(state)) {
            throw new IllegalArgumentException("Invalid application state: " + state);
        }
        this.id = id;
        this.state = state;
        this.date = date;
        this.candidateName = candidateName;
        this.jobOpeningTitle = jobOpeningTitle;
        this.numberOfApplicants = numberOfApplicants;
    }

    private boolean isValidState(String state) {
        for (String validState : ApplicationStates.applicationStates()) {
            if (validState.equals(state)) {
                return true;
            }
        }
        return false;
    }

    public ApplicationId id() {
        return this.id;
    }

    public String state() {
        return this.state;
    }

    public Date date() {
        return this.date;
    }

    public Candidate candidateName() {
        return this.candidateName;
    }

    public String jobOpeningTitle() {
        return this.jobOpeningTitle;
    }

    public int numberOfApplicants() {
        return this.numberOfApplicants;
    }
}
