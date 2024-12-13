package lapr4.jobs4u.jobopeningmanagement.application;

import lapr4.jobs4u.applicationmanagement.application.ApplicationService;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.rankmanagement.application.RankService;


public class PhaseService {

    private static final ApplicationService applicationService = new ApplicationService();
    private static final RankService rankService = new RankService();


    public static boolean checkIfIsPossibleToOpenNextPhase(JobOpening jobOpening) {
        String activePhaseName = jobOpening.recruitmentProcess().activePhase().getName();
        boolean hasInterview = jobOpening.recruitmentProcess().isHasInterview();

        switch (activePhaseName) {
            case "Application":
                if (jobOpening.hasRequirementsSpecification() &&
                        applicationService.checkIfApplicationsExistForJobOpening(jobOpening)) {
                    return true;
                }
                break;
            case "Screening":
                if (hasInterview && applicationService.checkIfAllApplicationsHaveBeenScreened(jobOpening)
                        && jobOpening.hasInterviewModel()) {
                    return true;
                } else if (!hasInterview && applicationService.checkIfAllApplicationsHaveBeenScreened(jobOpening)) {
                    return true;
                }
                break;
            case "Interview":
                if (applicationService.checkIfAllCandidatesHaveBeenInterviewed(jobOpening)) {
                    return true;
                }
                break;
            case "Analysis":
                if (hasInterview && rankService.checkIfAllCandidatesHaveBeenRanked(jobOpening) &&
                        applicationService.checkIfAllCandidatesHaveScore(jobOpening)) {
                    return true;
                } else if (!hasInterview && rankService.checkIfAllCandidatesHaveBeenRanked(jobOpening)) {
                    return true;
                }
                break;
            case "Result":
                return true;
        }
        return false;
    }


}
