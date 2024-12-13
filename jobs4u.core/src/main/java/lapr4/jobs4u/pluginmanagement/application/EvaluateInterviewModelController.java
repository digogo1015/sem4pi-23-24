package lapr4.jobs4u.pluginmanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.applicationmanagement.application.ApplicationService;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.JobOpeningService;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.pluginmanagement.domain.PlugIn;
import lapr4.jobs4u.usermanagement.domain.UserRoles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

@UseCaseController
public class EvaluateInterviewModelController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningService jobOpeningService = new JobOpeningService();
    private final ApplicationService applicationService = new ApplicationService();
    private final ApplicationRepository repoApp = PersistenceContext.repositories().applications();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

    private static final Logger LOGGER = LogManager.getLogger(DeployPluginController.class);

    public void evaluateInterviews(JobOpening jobOpening, List<Application> applications) throws IOException {

        try {
            PlugIn plugIn = jobOpening.interviewModel();

            Integer score;

            for (Application application : applications) {

                String answersFilePath = application.interview().interviewAnswerPath();

                final var importer = plugIn.buildImporter();
                score = importer.evaluateInterviewModel(plugIn.filePath(), answersFilePath);

                application.interview().giveInterviewPoints(score);
            }

            for (Application application : applications) {
                repoApp.save(application);
            }

        } catch (Exception ex) {
            LOGGER.error("Something unexpected happened", ex);

        }

    }

    public List<JobOpening> allJobOpeningsWithInterviewInAnalysis() {

        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);

        return jobOpeningService.allJobOpeningsWithInterviewInAnalysis(jobOpeningRepository.allJobOpeningsWithInterviewInAnalysis());
    }

    public List<Application> applicationsNotKnown(JobOpening jobOpening) {

        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);

        return repoApp.findAllNotKnown(jobOpening);
    }

}
