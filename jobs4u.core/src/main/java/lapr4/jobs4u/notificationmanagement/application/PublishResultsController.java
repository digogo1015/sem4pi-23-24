package lapr4.jobs4u.notificationmanagement.application;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationStates;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.JobOpeningService;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.rankmanagement.domain.Ranking;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;

import java.util.List;

public class PublishResultsController {
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final RankRepository rankRepository = PersistenceContext.repositories().ranks();
    private final JobOpeningService jobOpeningService = new JobOpeningService();
    private final ApplicationRepository applicationRepository = PersistenceContext.repositories().applications();
    private final NotificationService notificationService = new NotificationService();
    private static final EmailSender emailSender = new EmailSender();


    public List<JobOpening> allJobOpeningsInResults() {
        return jobOpeningService.allJobOpeningsInResults(jobOpeningRepository.allJobOpeningsWithRequirementsSpecification());
    }

    public Ranking findRankingByJobReference(final JobReference jobReference) {
        return rankRepository.findByRankJobReference(jobReference);
    }

    public void defineApplicationStateAccepted(Application application) {
        application.defineApplicationState(ApplicationStates.ACCEPTED);
        sendNotification(application);
        saveApplication(application);
    }

    public void defineApplicationStateRejected(Application application) {
        application.defineApplicationState(ApplicationStates.REJECTED);
        sendNotification(application);
        saveApplication(application);
    }

    public void defineEmailResult(Application application) {
        application.defineEmailResult(true);
        saveApplication(application);
    }

    private void saveApplication(Application application) {
        applicationRepository.save(application);
    }

    private void sendNotification(Application application){
        notificationService.publishApplicationChangeNotification(application.applicationState()
                ,application.applicationId().toString(),application.candidate().emailAddress());
    }

    public void sendEmail(Application application) {
        emailSender.sendEmail(application);
    }

    public void sendEmailForCustomer(Customer customer, List<Application> applications) {
        emailSender.sendEmailForCustomer(customer, applications);
    }

    public void defineCustomerNotification(JobOpening jobOpening) {
        jobOpening.defineEmailResult(true);
        jobOpeningRepository.save(jobOpening);
    }

    public List<Application> findAcceptedNonNotifiedApplications() {
        return applicationRepository.findAcceptedNonNotifiedApplications();
    }
}