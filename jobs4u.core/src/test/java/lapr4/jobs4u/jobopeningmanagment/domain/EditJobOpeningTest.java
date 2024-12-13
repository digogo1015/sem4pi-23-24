package lapr4.jobs4u.jobopeningmanagment.domain;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.domain.model.*;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerBuilder;
import lapr4.jobs4u.jobopeningmanagement.domain.*;
import lapr4.jobs4u.usermanagement.domain.UserRoles;
import static lapr4.jobs4u.jobopeningmanagment.domain.JobOpeningTest.exampleUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EditJobOpeningTest {

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
    void editJobTitleWithValidTitle() {
        String newTitle = "New Title";
        jobOpening.editJobTitle(newTitle);
        assertEquals(newTitle, jobOpening.title());
    }

    @Test
    void editJobTitleWithEmptyTitleShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editJobTitle(""));
    }

    @Test
    void editJobTitleWithNullTitleShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editJobTitle(null));
    }

    @Test
    void editDescriptionWithValidDescription() {
        String newDescription = "New Description";
        jobOpening.editDescription(newDescription);
        assertEquals(newDescription, jobOpening.description().toString());
    }

    @Test
    void editDescriptionWithEmptyDescriptionShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editDescription(""));
    }

    @Test
    void editDescriptionWithNullDescriptionShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editDescription(null));
    }

    @Test
    void editAddressWithValidAddress() {
        String newStreet = "New Street";
        String newCity = "New City";
        String newState = "New State";
        jobOpening.editAddress(newStreet, newCity, newState);
        assertEquals(newStreet, jobOpening.address().street());
        assertEquals(newCity, jobOpening.address().city());
        assertEquals(newState, jobOpening.address().state());
    }

    @Test
    void editAddressWithEmptyStreetShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editAddress("", "City", "State"));
    }

    @Test
    void editAddressWithEmptyCityShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editAddress("Street", "", "State"));
    }

    @Test
    void editAddressWithEmptyStateShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editAddress("Street", "City", ""));
    }

    @Test
    void editAddressWithNullStreetShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editAddress(null, "City", "State"));
    }

    @Test
    void editAddressWithNullCityShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editAddress("Street", null, "State"));
    }

    @Test
    void editAddressWithNullStateShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editAddress("Street", "City", null));
    }

    @Test
    void editJobOpeningModeWithValidMode() {
        String newMode = "Part-time";
        jobOpening.editJobOpeningMode(newMode);
        assertEquals(newMode, jobOpening.jobOpeningMode());
    }

    @Test
    void editJobOpeningModeWithEmptyModeShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editJobOpeningMode(""));
    }

    @Test
    void editJobOpeningModeWithNullModeShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editJobOpeningMode(null));
    }

    @Test
    void editContractTypeWithValidType() {
        String newType = "Temporary";
        jobOpening.editContractType(newType);
        assertEquals(newType, jobOpening.contractType());
    }

    @Test
    void editContractTypeWithEmptyTypeShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editContractType(""));
    }

    @Test
    void editContractTypeWithNullTypeShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editContractType(null));
    }

    @Test
    void editNumberOfVacanciesWithValidNumber() {
        Integer newNumber = 3;
        jobOpening.editNumberOfVacancies(newNumber);
        assertEquals(newNumber, jobOpening.numberOfVacancies());
    }

    @Test
    void editNumberOfVacanciesWithZeroNumberShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editNumberOfVacancies(0));
    }

    @Test
    void editNumberOfVacanciesWithNegativeNumberShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editNumberOfVacancies(-1));
    }

    @Test
    void editNumberOfVacanciesWithNullNumberShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobOpening.editNumberOfVacancies(null));
    }

    @Test
    void editJobTitleWithPhaseShouldThrowException() {
        jobOpening.recruitmentProcess().openNextPhase();
        Assertions.assertThrows(IllegalStateException.class, () -> jobOpening.editJobTitle("New Title"));
    }

    @Test
    void editDescriptionWithPhaseShouldThrowException() {
        jobOpening.recruitmentProcess().openNextPhase();
        Assertions.assertThrows(IllegalStateException.class, () -> jobOpening.editDescription("New Description"));
    }

    @Test
    void editAddressWithPhaseShouldThrowException() {
        jobOpening.recruitmentProcess().openNextPhase();
        Assertions.assertThrows(IllegalStateException.class, () -> jobOpening.editAddress("New Street", "New City", "New State"));
    }

    @Test
    void editJobOpeningModeWithPhaseShouldThrowException() {
        jobOpening.recruitmentProcess().openNextPhase();
        Assertions.assertThrows(IllegalStateException.class, () -> jobOpening.editJobOpeningMode("Part-time"));
    }

    @Test
    void editContractTypeWithPhaseShouldThrowException() {
        jobOpening.recruitmentProcess().openNextPhase();
        Assertions.assertThrows(IllegalStateException.class, () -> jobOpening.editContractType("Temporary"));
    }

    @Test
    void editNumberOfVacanciesWithPhaseShouldThrowException() {
        jobOpening.recruitmentProcess().openNextPhase();
        Assertions.assertThrows(IllegalStateException.class, () -> jobOpening.editNumberOfVacancies(3));
    }

    @Test
    void editJobTitleWithNullPhase() {
        jobOpening.recruitmentProcess().complete();
        String newTitle = "New Title";
        Assertions.assertThrows(IllegalStateException.class, () -> jobOpening.editJobTitle(newTitle));
    }

    @Test
    void editDescriptionWithNullPhase() {
        jobOpening.recruitmentProcess().complete();
        String newDescription = "New Description";
        Assertions.assertThrows(IllegalStateException.class, () -> jobOpening.editDescription(newDescription));
    }

    @Test
    void editAddressWithNullPhase() {
        jobOpening.recruitmentProcess().complete();
        String newStreet = "New Street";
        String newCity = "New City";
        String newState = "New State";
        Assertions.assertThrows(IllegalStateException.class, () -> jobOpening.editAddress(newStreet, newCity, newState));
    }

    @Test
    void editJobOpeningModeWithNullPhase() {
        jobOpening.recruitmentProcess().complete();
        String newMode = "Part-time";
        Assertions.assertThrows(IllegalStateException.class, () -> jobOpening.editJobOpeningMode(newMode));
    }

    @Test
    void editContractTypeWithNullPhase() {
        jobOpening.recruitmentProcess().complete();
        String newType = "Temporary";
        Assertions.assertThrows(IllegalStateException.class, () -> jobOpening.editContractType(newType));
    }

    @Test
    void editNumberOfVacanciesWithNullPhase() {
        jobOpening.recruitmentProcess().complete();
        Integer newNumber = 3;
        Assertions.assertThrows(IllegalStateException.class, () -> jobOpening.editNumberOfVacancies(newNumber));
    }





}

