package lapr4.jobs4u.jobopeningmanagement.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Entity
public class Phase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    private String name;
    private LocalDate begginingDate;
    @Getter
    private LocalDate endingDate;
    private String phaseState;


    public Phase(String name, LocalDate begginingDate, LocalDate endingDate) {
        this.name = name;
        this.begginingDate = begginingDate;
        this.endingDate = endingDate;
        this.phaseState = PhaseState.NOT_ACTIVE;
    }

    protected Phase(){

    }

    public LocalDate getBeginningDate() {
        return this.begginingDate;
    }

    public boolean isActive() {
        if (phaseState.equals("ONGOING")) {
            return true;
        } else if (phaseState.equals("NOT_ACTIVE")) {
            return false;
        } else {
            return false;
        }
    }
    public void activatePhase() {
        this.phaseState = PhaseState.ONGOING;
    }
    public void deactivatePhase() {
        this.phaseState = PhaseState.NOT_ACTIVE;
    }

    @Override
    public String toString() {
        return getName();
    }
}
