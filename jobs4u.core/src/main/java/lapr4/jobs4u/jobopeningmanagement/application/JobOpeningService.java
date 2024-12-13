package lapr4.jobs4u.jobopeningmanagement.application;

import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.Phase;
import lapr4.jobs4u.jobopeningmanagement.domain.PhaseNames;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;

import java.util.ArrayList;
import java.util.List;

public class JobOpeningService {

    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();


    public List<JobOpening> allJobOpeningsInAnalysis(List<JobOpening> jobOpenings) {
        List<JobOpening> jobOpeningsList = new ArrayList<>();

        for (JobOpening jobOpening : jobOpenings) {
            Phase phase = jobOpening.recruitmentProcess().activePhase();
            if (phase != null && phase.getName().equals(PhaseNames.ANALYSIS.getName()))
                jobOpeningsList.add(jobOpening);
        }
        return jobOpeningsList;
    }

    //PARA DEIXAR ESTE
    public List<JobOpening> allJobOpeningsInResults(List<JobOpening> jobOpenings) {
        List<JobOpening> jobOpeningsList = new ArrayList<>();

        for (JobOpening jobOpening : jobOpenings) {
            Phase phase = jobOpening.recruitmentProcess().activePhase();
            if (phase != null && phase.getName().equals(PhaseNames.RESULT.getName()))
                jobOpeningsList.add(jobOpening);
        }
        return jobOpeningsList;
    }


    //PARA DEIXAR ESTE
    public List<JobOpening> allJobOpeningsWithInterviewInAnalysis(List<JobOpening> jobOpenings) {
        List<JobOpening> list = new ArrayList<>();

        for (JobOpening jobOpening : jobOpenings) {
            Phase phase = jobOpening.recruitmentProcess().activePhase();
            if (phase != null && phase.getName().equals(PhaseNames.ANALYSIS.getName())) {
                list.add(jobOpening);
            }
        }
        return list;
    }


    public String numberOfJobOpeningsByCustomer(Customer customer){
        List<JobOpening> jobOpenings = jobOpeningRepository.jobOpeningByCustomer(customer);
        return String.valueOf(jobOpenings.size());
    }

    public List<JobOpeningDTO> allCustomerJobOpeningsWithRecruitmentProcess(Customer customer) {

        List<JobOpening> jobOpenings = jobOpeningRepository.findCustomerJobOpeningsWithRecruitmentProcess(customer);

        final List<JobOpeningDTO> ret = new ArrayList<>();
        jobOpenings.forEach(e -> ret.add(new JobOpeningDTO(e.title(), e.reference().toString(), e.recruitmentProcess().getPhaseByName(PhaseNames.APPLICATION.getName()).getBeginningDate().toString(),e.numberOfVacancies().toString())));
        return ret;
    }


}
