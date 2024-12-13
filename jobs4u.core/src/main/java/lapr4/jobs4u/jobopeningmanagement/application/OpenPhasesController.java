package lapr4.jobs4u.jobopeningmanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.Phase;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.notificationmanagement.application.NotificationService;
import lapr4.jobs4u.usermanagement.domain.UserRoles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class OpenPhasesController {

    private static final Logger LOGGER = LogManager.getLogger(RegisterJobOpeningController.class);
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final NotificationService notificationService = new NotificationService();


    // returns a list of all job openings
    public List<JobOpening> getListOfJobOpenings(){

        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);

        Iterable<JobOpening> jobOpenings = jobOpeningRepository.jobOpeningByManager(authz.session().get().authenticatedUser());

        return StreamSupport.stream(jobOpenings.spliterator(), false)
                .collect(Collectors.toList());

    }

    public boolean checkIfHasRecruitmentProcess(JobOpening jobOpening){
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);
        return jobOpening.hasRecruitmentProcess();
    }
    public boolean checkIfIsCompleted(JobOpening jobOpening){
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);
        return jobOpening.recruitmentProcess().isCompleted();
    }

    public boolean checkIfHasActivePhase(JobOpening jobOpening){
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);
        return jobOpening.recruitmentProcess().hasActivePhase() ;
    }


    // returns the active phase of the job opening
    public Phase showJobOpeningCurrentPhase(JobOpening jobOpening){
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);
        return jobOpening.recruitmentProcess().activePhase();
    }


    // checks if it is possible to open the next phase of the job opening
    public boolean checkIfIsPossibleToOpenNextPhase(JobOpening jobOpening){
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);
        return PhaseService.checkIfIsPossibleToOpenNextPhase(jobOpening);
    }



    // opens the next phase of the job opening
    public boolean openNextPhase(JobOpening jobOpening){

        try {
            authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);

            boolean success = jobOpening.recruitmentProcess().openNextPhase();

            jobOpeningRepository.save(jobOpening);

            notificationService.publishPhaseChangeNotification(jobOpening.recruitmentProcess().activePhase().getName(),
                    jobOpening.reference().toString(),jobOpening.customer().user().email());

            return success;

        }catch (Exception ex){
            LOGGER.error("ERRO", ex);}

        return false;
    }
}
