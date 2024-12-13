package lapr4.jobs4u.jobopeningmanagment.domain;

import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerBuilder;
import lapr4.jobs4u.jobopeningmanagement.domain.*;
import lapr4.jobs4u.usermanagement.domain.UserRoles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static lapr4.jobs4u.jobopeningmanagment.domain.JobOpeningTest.exampleUser;
import static org.junit.jupiter.api.Assertions.*;

public class OpenPhasesTest {

    private JobOpening jobOpening;

    private SystemUser getNewCustomerUser() {
        return exampleUser("test@test.com", UserRoles.CUSTOMER);
    }

    @BeforeEach
    void setUp() {
        JobReference jobReference = new JobReference("ISEP","123");
        Description description = Description.valueOf("Test description");
        Address address = new Address("123 Street", "City", "state");
        String jobOpeningMode = "Full-time";
        String jobTitle = "Software Engineer";
        String jobOpeningState = "Open";
        String contractType = "Permanent";
        Integer numberOfVacancies = 2;
        SystemUser manager = getNewCustomerUser();
        Customer customer = new CustomerBuilder().withCustomerCode("IGUAL").withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        jobOpening = new JobOpening(jobReference, description, address, jobOpeningMode, jobTitle, jobOpeningState,
                contractType, numberOfVacancies, manager, customer);

        List<Phase> phases = new ArrayList<>();
        phases.add(new Phase("Application", LocalDate.of(2024, 5, 15), LocalDate.of(2024, 5, 15)));
        phases.add(new Phase("Screening", LocalDate.of(2024, 5, 15), LocalDate.of(2024, 5, 15)));
        phases.add(new Phase("Interview", LocalDate.of(2024, 5, 15), LocalDate.of(2024, 5, 15)));
        phases.add(new Phase("Analysis", LocalDate.of(2024, 5, 15), LocalDate.of(2024, 5, 15)));
        phases.add(new Phase("Result", LocalDate.of(2024, 5, 15), LocalDate.of(2024, 5, 15)));

        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(true, phases);
        jobOpening.setupPhases(recruitmentProcess);

    }


    @Test
    void testHasActivePhase() {
        assertFalse(jobOpening.recruitmentProcess().hasActivePhase());
    }

    @Test
    void testIsCompleted() {
        assertFalse(jobOpening.recruitmentProcess().isCompleted());
    }

    @Test
    void testopenNextPhaseMetod() {
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
    }

    @Test
    void testActivePhase() {
        assertNull(jobOpening.recruitmentProcess().activePhase());
    }


    @Test
    void testOpenNextPhase() {
        assertFalse(jobOpening.recruitmentProcess().hasActivePhase());
        assertFalse(jobOpening.recruitmentProcess().isCompleted());

        assertTrue(jobOpening.recruitmentProcess().openNextPhase());

        assertTrue(jobOpening.recruitmentProcess().hasActivePhase());
        assertEquals(jobOpening.recruitmentProcess().activePhase(), jobOpening.recruitmentProcess().getPhaseByName("Application"));
    }

    @Test
    void testOpenNextPhase2() {
        assertFalse(jobOpening.recruitmentProcess().hasActivePhase());
        assertFalse(jobOpening.recruitmentProcess().isCompleted());

        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());

        assertEquals(jobOpening.recruitmentProcess().activePhase(), jobOpening.recruitmentProcess().getPhaseByName("Screening"));
    }

    @Test
    void testOpenNextPhase3() {
        assertFalse(jobOpening.recruitmentProcess().hasActivePhase());
        assertFalse(jobOpening.recruitmentProcess().isCompleted());

        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());

        assertEquals(jobOpening.recruitmentProcess().activePhase(), jobOpening.recruitmentProcess().getPhaseByName("Interview"));
    }

    @Test
    void testOpenNextPhase4() {
        assertFalse(jobOpening.recruitmentProcess().hasActivePhase());
        assertFalse(jobOpening.recruitmentProcess().isCompleted());

        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());

        assertEquals(jobOpening.recruitmentProcess().activePhase(), jobOpening.recruitmentProcess().getPhaseByName("Analysis"));
    }

    @Test
    void testOpenNextPhase5() {
        assertFalse(jobOpening.recruitmentProcess().hasActivePhase());
        assertFalse(jobOpening.recruitmentProcess().isCompleted());

        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());

        assertEquals(jobOpening.recruitmentProcess().activePhase(), jobOpening.recruitmentProcess().getPhaseByName("Result"));
    }

    @Test
    void testOpenNextPhase6() {
        assertFalse(jobOpening.recruitmentProcess().hasActivePhase());
        assertFalse(jobOpening.recruitmentProcess().isCompleted());

        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());
        assertTrue(jobOpening.recruitmentProcess().openNextPhase());

        assertFalse(jobOpening.recruitmentProcess().hasActivePhase());
        assertTrue(jobOpening.recruitmentProcess().isCompleted());
    }



}
