package lapr4.jobs4u.applicationmanagement.application;

import eapli.framework.general.domain.model.EmailAddress;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.rankmanagement.domain.Order1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ApplicationService {

    private final ApplicationRepository applicationRepository = PersistenceContext.repositories().applications();


    public List<Application> allApplications() {
        return (List<Application>) this.applicationRepository.findAll();
    }

    public List<Application> applicationsOfJobOpening(JobOpening jobOpening) {
        List<Application> allApplications = allApplications();
        List<Application> applications = new ArrayList<>();

        for (Application a : allApplications) {
            if (a.jobOpening().equals(jobOpening))
                applications.add(a);
        }
        return applications;
    }


    public List<Application> applicationsByApplicationId(List<Order1> applicationIds) {
        List<Application> allApplications = allApplications();
        List<Application> applications = new ArrayList<>();

        return allApplications;
    }

    public List<EmailAddress> candidateEmailsOfApplications(List<Application> applications) {
        List<EmailAddress> emails = new ArrayList<>();

        for (Application application : applications)
            emails.add(application.candidate().emailAddress());

        return emails;
    }

    public List<Application> sortApplicationsByInterviewPoints(List<Application> applications) {
        applications.sort(new Comparator<Application>() {
            @Override
            public int compare(Application a1, Application a2) {
                return a2.interview().interviewPoints().compareTo(a1.interview().interviewPoints());
            }
        });
        return applications;
    }

    public boolean checkIfApplicationsExistForJobOpening(JobOpening jobOpening) {
        List<Application> applications = applicationsOfJobOpening(jobOpening);
        return !applications.isEmpty();
    }

    public boolean checkIfAllApplicationsHaveBeenScreened(JobOpening jobOpening) {
        List<Application> applications = applicationsOfJobOpening(jobOpening);
        for (Application application : applications) {
            if (!application.hasScreeningResult())
                return false;
        }
        return true;
    }

    public boolean checkIfAllCandidatesHaveBeenInterviewed(JobOpening jobOpening) {
        List<Application> applications = applicationsOfJobOpening(jobOpening);
        for (Application application : applications) {
            if (application.interview().interviewAnswerPath() == null ||
                    application.interview().interviewAnswerPath().isEmpty())
                return false;
        }
        return true;
    }

    public boolean checkIfAllCandidatesHaveScore(JobOpening jobOpening) {
        List<Application> applications = applicationsOfJobOpening(jobOpening);
        for (Application application : applications) {
            if (!application.hasInterview() || !application.interview().hasInterviewPoints())
                return false;
        }
        return true;
    }
}
