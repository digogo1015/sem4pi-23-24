/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package lapr4.jobs4u.jobopeningmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jakarta.persistence.*;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.pluginmanagement.domain.PlugIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Entity
public class JobOpening implements AggregateRoot<JobReference> {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LogManager.getLogger(JobOpening.class);
    @Version
    private Long version;

    @EmbeddedId
    private JobReference reference;
    private String jobTitle;
    private Description description;
    private Address address;
    private String jobOpeningMode;
    private String contractType;
    private Integer numberOfVacancies;
    @ManyToOne
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    private RecruitmentProcess recruitmentProcess;
    private String jobOpeningState;
    @ManyToOne
    private SystemUser manager;
    @ManyToOne
    private PlugIn InterviewModel;
    @ManyToOne
    private PlugIn RequirementsSpecification;
    @Column(name = "EmailSent")
    private boolean emailResult;

    public JobOpening(final JobReference jobReference, final Description description, final Address address,
                      final String jobOpeningMode, final String jobTitle, final String jobOpeningState,
                      final String contractType, final Integer numberOfVacancies, final SystemUser manager,
                      final Customer customer) {

        if (jobReference == null || description == null || address == null || jobOpeningMode == null || jobTitle == null
                || jobOpeningState == null || contractType == null || numberOfVacancies == null || manager == null
                || customer == null) {
            throw new IllegalArgumentException();
        }


        this.reference = jobReference;
        this.description = description;
        this.address = address;
        this.jobOpeningMode = jobOpeningMode;
        this.jobTitle = jobTitle;
        this.jobOpeningState = jobOpeningState;
        this.contractType = contractType;
        this.numberOfVacancies = numberOfVacancies;
        this.manager = manager;
        this.customer = customer;
        this.emailResult = false;
    }

    protected JobOpening() {
    }

    public void setupPhases(RecruitmentProcess recruitmentProcess) {
        this.recruitmentProcess = recruitmentProcess;
    }

    public RecruitmentProcess recruitmentProcess() {
        if (recruitmentProcess != null) return this.recruitmentProcess;
        else throw new IllegalStateException("Recruitment Process not defined");
    }

    public boolean hasRecruitmentProcess() {
        return this.recruitmentProcess != null;
    }

    public boolean hasInterviewModel() {
        return this.InterviewModel != null;
    }

    public boolean hasRequirementsSpecification() {
        return this.RequirementsSpecification != null;
    }


    public PlugIn interviewModel() {
        return this.InterviewModel;
    }

    public String title() {
        return this.jobTitle;
    }

    public PlugIn requirementsSpecification() {
        return this.RequirementsSpecification;
    }

    public SystemUser manager() {
        return this.manager;
    }

    public Customer customer() {
        return this.customer;
    }

    public Integer numberOfVacancies() {
        return this.numberOfVacancies;
    }

    public JobReference reference() {
        return identity();
    }

    public Description description() {
        return this.description;
    }

    public Address address() {
        return this.address;
    }

    public String jobOpeningMode() {
        return this.jobOpeningMode;
    }

    public String contractType() {
        return this.contractType;
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

    @Override
    public JobReference identity() {
        return this.reference;
    }

    public void InterviewModelSelected(PlugIn interviewModel) {
        this.InterviewModel = interviewModel;
    }

    public void RequirementSpecificationSelected(PlugIn requirementsSpecification) {
        this.RequirementsSpecification = requirementsSpecification;
    }

    public void editJobTitle(String jobTitle) {
        if (jobTitle == null || jobTitle.isEmpty()) {
            throw new IllegalArgumentException("Job Title should not be empty");
        }
        if (recruitmentProcess == null || recruitmentProcess.canEdit()) {
            this.jobTitle = jobTitle;
        } else {
            throw new IllegalStateException("Job Title cannot be edited because of current phase!");
        }
    }

    public void editDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description should not be empty");
        }
        if (recruitmentProcess == null || recruitmentProcess.canEdit()) {
            this.description = Description.valueOf(description);
        } else {
            throw new IllegalStateException("Description cannot be edited because of current phase!");
        }
    }

    public void editAddress(String street, String city, String state) {
        if (street == null || street.isEmpty() || city == null || city.isEmpty() || state == null || state.isEmpty()) {
            throw new IllegalArgumentException("Address should not be empty");
        }
        if (recruitmentProcess == null || recruitmentProcess.canEdit()) {
            this.address = new Address(street, city, state);
        } else {
            throw new IllegalStateException("Address cannot be edited because of current phase!");
        }
    }

    public void editJobOpeningMode(String jobOpeningMode) {
        if (jobOpeningMode == null || jobOpeningMode.isEmpty()) {
            throw new IllegalArgumentException("Job Opening Mode should not be empty");
        }
        if (recruitmentProcess == null || recruitmentProcess.canEdit()) {
            this.jobOpeningMode = jobOpeningMode;
        } else {
            throw new IllegalStateException("Job Opening Mode cannot be edited because of current phase!");
        }
    }

    public void editContractType(String contractType) {
        if (contractType == null || contractType.isEmpty()) {
            throw new IllegalArgumentException("Contract Type should not be empty");
        }
        if (recruitmentProcess == null || recruitmentProcess.canEdit()) {
            this.contractType = contractType;
        } else {
            throw new IllegalStateException("Contract Type cannot be edited because of current phase!");
        }
    }

    public void editNumberOfVacancies(Integer numberOfVacancies) {
        if (numberOfVacancies == null || numberOfVacancies <= 0) {
            throw new IllegalArgumentException("Number of Vacancies should be greater than 0");
        }
        if (recruitmentProcess == null || recruitmentProcess.canEdit()) {
            this.numberOfVacancies = numberOfVacancies;
        } else {
            throw new IllegalStateException("Number of vacancies cannot be edited because of current phase!");
        }

    }

    @Override
    public String toString() {
        return "JobOpening" +
                " Reference: " + reference +
                " JobTitle: '" + jobTitle + "'";
    }

    public String toStringWithActivePhase() {
        return "JobOpening" +
                " Reference: '" + reference + "'" +
                " JobTitle: '" + jobTitle + "'"
                + " " + phaseToString();
    }

    public String phaseToString() {
        if (!hasRecruitmentProcess()) return " Recruitment process not defined";
        if (recruitmentProcess.hasActivePhase()) return "Active Phase: " + recruitmentProcess.activePhase();
        if (!recruitmentProcess.hasActivePhase()) {
            if (recruitmentProcess.isCompleted()) return " Recruitment process completed";
            else return " Recruitment process not started yet";
        }
        return "";
    }

    public boolean emailResult() {
        return this.emailResult;
    }

    public void defineEmailResult(boolean emailResult) {
        this.emailResult = emailResult;
    }
}
