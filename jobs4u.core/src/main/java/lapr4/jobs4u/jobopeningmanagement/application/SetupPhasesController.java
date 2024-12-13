package lapr4.jobs4u.jobopeningmanagement.application;

import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.domain.*;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SetupPhasesController {

    private static final Logger LOGGER = LogManager.getLogger(SetupPhasesController.class);
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();


    public boolean setupPhases(final JobOpening jobOpening,final  boolean hasInterview,final LocalDate applicationBegDate,
                               final LocalDate screeningBegDate, final LocalDate interviewBegDate, final LocalDate analysisBegDate,
                               final LocalDate resultBegDate, final LocalDate resultEndDate) {

        try {

            List<Phase> phases = new ArrayList<>();
            Phase applicationPhase = new Phase("Application",applicationBegDate,screeningBegDate);
            phases.add(applicationPhase);
            if (hasInterview){
                Phase screeningPhase = new Phase("Screening",screeningBegDate,interviewBegDate);
                phases.add(screeningPhase);
                Phase interviewPhase = new Phase("Interview",interviewBegDate,analysisBegDate);
                phases.add(interviewPhase);
            }else {
                Phase screeningPhase = new Phase("Screening",screeningBegDate,analysisBegDate);
                phases.add(screeningPhase);

            }
            Phase analysisPhase = new Phase("Analysis",analysisBegDate,resultBegDate);
            phases.add(analysisPhase);
            Phase resultPhase = new Phase("Result",resultBegDate,resultEndDate);
            phases.add(resultPhase);

            RecruitmentProcess recruitmentProcess = new RecruitmentProcess(hasInterview,phases);

            jobOpening.setupPhases(recruitmentProcess);

            jobOpeningRepository.save(jobOpening);

        } catch (Exception ex) {
            LOGGER.error("ERRO", ex);
        }

        return true;
    }



    public List<JobOpening> getListOfJobOpenings(){

        Iterable<JobOpening> jobOpenings = jobOpeningRepository.findAll();

        return StreamSupport.stream(jobOpenings.spliterator(), false)
                .collect(Collectors.toList());

    }




}
