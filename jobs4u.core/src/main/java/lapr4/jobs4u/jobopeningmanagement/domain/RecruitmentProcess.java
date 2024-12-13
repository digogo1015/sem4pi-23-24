package lapr4.jobs4u.jobopeningmanagement.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RecruitmentProcess implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter @Column
    private boolean hasInterview = true;
    @Getter @OneToMany(cascade = CascadeType.ALL)
    private List<Phase> phases = new ArrayList<>();
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column @Getter
    private boolean completed = false;



    public RecruitmentProcess(boolean hasInterview, List<Phase> phases) {
        if ((phases == null) || (phases.isEmpty()))
            throw new IllegalArgumentException();

        this.hasInterview = hasInterview;
        this.phases = phases;
    }

    protected RecruitmentProcess() {
        // for ORM
    }

    public Phase activePhase() {
        Phase activePhase = null;
        for (Phase phase : phases) {
            if (phase.isActive()) {
                if (activePhase != null)
                    throw new IllegalStateException("More than one active phase found");
                activePhase = phase;
            }
        }
        return activePhase;
    }

    public Phase getPhaseByName(String phaseName) {
        for (Phase phase : phases) {
            if (phase.getName().equals(phaseName)) {
                return phase;
            }
        }
        return null;
    }

    public boolean hasActivePhase() {
        for (Phase phase : phases) {
            if (phase.isActive()) {
                return true;
            }
        }
        return false;
    }

    public void complete(){
        this.completed = true;
    }

    public boolean openNextPhase() {
        if (!hasActivePhase()) {
            getPhaseByName(PhaseNames.APPLICATION.getName()).activatePhase();
            return true;
        }

        Phase activePhase = activePhase();
        activePhase.deactivatePhase();

        switch (activePhase.getName()) {
            case "Application":
                getPhaseByName(PhaseNames.SCREENING.getName()).activatePhase();
                return true;
            case "Screening":
                if (hasInterview) {
                    getPhaseByName(PhaseNames.INTERVIEW.getName()).activatePhase();
                } else {
                    getPhaseByName(PhaseNames.ANALYSIS.getName()).activatePhase();
                }
                return true;
            case "Interview":
                getPhaseByName(PhaseNames.ANALYSIS.getName()).activatePhase();
                return true;
            case "Analysis":
                getPhaseByName(PhaseNames.RESULT.getName()).activatePhase();

                return true;
            case "Result":
                complete();
                return true;
        }
        return false;
    }


    public boolean canEdit() {
        return !hasActivePhase() && !completed;
    }
}
