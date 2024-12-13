package lapr4.jobs4u.jobopeningmanagment.domain;

import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.domain.model.*;
import lapr4.jobs4u.jobopeningmanagement.domain.*;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerBuilder;
import lapr4.jobs4u.usermanagement.domain.UserRoles;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RecruitmentProcessTest {



    public static SystemUser exampleUser(final String email, final Role... roles) {
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());

        return userBuilder.with(email, "Password1+", "Exemplo", "Exemplo", email).withRoles(roles).build();
    }

    private SystemUser getNewCustomerUser() {
        return exampleUser("test@test.com", UserRoles.CUSTOMER);
    }


    @Test
    public void testConstructorWithValidArguments() {
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

        JobOpening jobOpening = new JobOpening(jobReference, description, address, jobOpeningMode, jobTitle, jobOpeningState,
                contractType, numberOfVacancies, manager, customer);

        List<Phase> phases = new ArrayList<>();
        phases.add(new Phase("Interview", LocalDate.of(2024, 5, 1), LocalDate.of(2024, 5, 10)));
        phases.add(new Phase("Analysis", LocalDate.of(2024, 5, 15), LocalDate.of(2024, 5, 20)));

        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(true, phases);

        assertNotNull(recruitmentProcess);
        assertEquals(2, recruitmentProcess.getPhases().size());
        assertEquals("Interview", recruitmentProcess.getPhases().get(0).getName());
        assertEquals(LocalDate.of(2024, 5, 1), recruitmentProcess.getPhases().get(0).getBeginningDate());
        assertEquals(LocalDate.of(2024, 5, 10), recruitmentProcess.getPhases().get(0).getEndingDate());
        assertEquals("Analysis", recruitmentProcess.getPhases().get(1).getName());
        assertEquals(LocalDate.of(2024, 5, 15), recruitmentProcess.getPhases().get(1).getBeginningDate());
        assertEquals(LocalDate.of(2024, 5, 20), recruitmentProcess.getPhases().get(1).getEndingDate());
    }

    @Test
    public void testConstructorWithNullArguments() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RecruitmentProcess(true, null);
        });
    }

    @Test
    public void testConstructorWithNoPhases() {
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

        JobOpening jobOpening = new JobOpening(jobReference, description, address, jobOpeningMode, jobTitle, jobOpeningState,
                contractType, numberOfVacancies, manager, customer);

        assertThrows(IllegalArgumentException.class, () -> {
            new RecruitmentProcess(true, new ArrayList<>());
        });
    }

}