package lapr4.jobs4u.notificationmanagement.application;

import lapr4.jobs4u.candidatemanagement.domain.Candidate;

import java.util.List;

public class EmailDTO {

    private final String customerManagerName;
    private final String toEmail;
    private final String fromEmail;
    private final String fromName;
    private final String toName;
    private final String companyName;
    private final List<Candidate> candidateList;

    public EmailDTO(String customerManagerName, String toEmail, String fromEmail, String fromName, String candidateName, String companyName) {
        this.customerManagerName = customerManagerName;
        this.toEmail = toEmail;
        this.fromEmail = fromEmail;
        this.fromName = fromName;
        this.toName = candidateName;
        this.companyName = companyName;
        this.candidateList = null;
    }

    public EmailDTO(String customerManagerName, String toEmail, String fromEmail, String fromName, String toName, String companyName, List<Candidate> candidateList) {
        this.customerManagerName = customerManagerName;
        this.toEmail = toEmail;
        this.fromEmail = fromEmail;
        this.fromName = fromName;
        this.toName = toName;
        this.companyName = companyName;
        this.candidateList = candidateList;
    }


    public String fromEmail() {
        return this.fromEmail;
    }

    public String toEmail() {
        return this.toEmail;
    }

    public String fromName() {
        return this.fromName;
    }

    public String toName() {
        return this.toName;
    }

    public String yourName() {
        return this.customerManagerName;
    }

    public String companyName() {
        return this.companyName;
    }

    public List<Candidate> candidateList() {
        return this.candidateList;
    }

}
