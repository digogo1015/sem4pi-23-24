package lapr4.jobs4u.notificationmanagement.application;


import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

import java.util.ArrayList;
import java.util.List;

public class EmailSender {
    private final NotificationService notificationService = new NotificationService();

    public void sendEmail(Application application) {
        Candidate candidate = application.candidate();
        EmailAddress toEmail = candidate.emailAddress();
        SystemUser customerManager = application.jobOpening().manager();

        EmailDTO email = new EmailDTO(customerManager.name().toString(), toEmail.toString(),
                customerManager.email().toString(), customerManager.name().toString(),
                candidate.fullName(), application.jobOpening().customer().user().username().toString());

        try {
            notificationService.sendEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendEmailForCustomer(Customer customer, List<Application> applications) {
        JobOpening jobOpening = applications.get(0).jobOpening();
        List<Candidate> candidateList = new ArrayList<>();

        for (Application application : applications)
            candidateList.add(application.candidate());

        EmailDTO email = new EmailDTO(jobOpening.manager().name().toString(), customer.user().email().toString(), jobOpening.manager().email().toString(),
                jobOpening.manager().name().toString(), customer.user().name().toString(), customer.user().name().toString(), candidateList);

        try {
            notificationService.sendEmailForCustomer(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

