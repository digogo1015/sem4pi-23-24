package lapr4.jobs4u.applicationmanagement.application;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.reflect.Field;

public class ListCandidateApplicationsController {

    private final ApplicationRepository applicationRepository = PersistenceContext.repositories().applications();

    public List<ApplicationDTO> listApplicationsByCandidate(Candidate candidate) {
        List<Application> applications = applicationRepository.findApplicationsByCandidate(candidate);
        List<ApplicationDTO> applicationDTOs = new ArrayList<>();

        for (Application application : applications) {
            int numberOfApplicants = applicationRepository.countByJobOpening(application.jobOpening());
            String jobOpeningTitle = application.jobOpening().title();

            // Acesso ao dado privado da data
            Date applicationDate = null;
            try {
                Field dateField = Application.class.getDeclaredField("date");
                dateField.setAccessible(true);
                applicationDate = (Date) dateField.get(application);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }

            applicationDTOs.add(new ApplicationDTO(
                    application.identity(),
                    application.applicationState(),
                    applicationDate,
                    application.candidate(),
                    jobOpeningTitle,
                    numberOfApplicants
            ));
        }

        return applicationDTOs;
    }
}
