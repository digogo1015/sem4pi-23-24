package lapr4.jobs4u.rankmanagemant.domain;

import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.domain.model.*;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationId;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.domain.CandidateBuilder;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerBuilder;
import lapr4.jobs4u.jobopeningmanagement.domain.*;
import lapr4.jobs4u.rankmanagement.domain.Order1;
import lapr4.jobs4u.rankmanagement.domain.Rank;
import lapr4.jobs4u.usermanagement.domain.UserRoles;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


public class OrderTest {

    public static SystemUser exampleUser(final String email, final Role... roles) {
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());

        return userBuilder.with(email, "Password1+", "Exemplo", "Exemplo", email).withRoles(roles).build();
    }

    private SystemUser getNewCustomerUser() {
        return exampleUser("test@test.com", UserRoles.CUSTOMER);
    }

    private SystemUser getNewCandidateUser() {
        return exampleUser("test@test.com", UserRoles.CANDIDATE);
    }


    private JobReference jobReference;
    private Description description;
    private Address address;
    private String jobOpeningMode;
    private String jobTitle;
    private String jobOpeningState;
    private String contractType;
    private Integer numberOfVacancies;
    private SystemUser manager;
    private Customer customer;
    private String email1;
    private JobOpening jobOpening;
    private List<Phase> phases;
    private RecruitmentProcess recruitmentProcess;
    private ApplicationId applicationId;
    private Date date;
    private String pathApplicationFolder;
    private Candidate candidate;
    private Application application;
    private Order1 o1;
    private Order1 o2;
    private Rank r1;
    private Rank r2;

    @Before
    public void setUp() throws IllegalAccessException {
        jobReference = new JobReference("ISEP", "123");
        description = Description.valueOf("Test description");
        address = new Address("123 Street", "City", "state");
        jobOpeningMode = "Full-time";
        jobTitle = "Software Engineer";
        jobOpeningState = "Open";
        contractType = "Permanent";
        numberOfVacancies = 2;
        manager = getNewCustomerUser();
        customer = new CustomerBuilder().withCustomerCode("IGUAL").withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();
        email1 = "test1@test.com";

        jobOpening = new JobOpening(jobReference, description, address, jobOpeningMode, jobTitle, jobOpeningState,
                contractType, numberOfVacancies, manager, customer);

        phases = new ArrayList<>();
        phases.add(new Phase("Application", LocalDate.of(2024, 5, 15), LocalDate.of(2024, 5, 15)));
        phases.add(new Phase("Screening", LocalDate.of(2024, 5, 15), LocalDate.of(2024, 5, 15)));
        phases.add(new Phase("Interview", LocalDate.of(2024, 5, 15), LocalDate.of(2024, 5, 15)));
        phases.add(new Phase("Analysis", LocalDate.of(2024, 5, 15), LocalDate.of(2024, 5, 15)));
        phases.add(new Phase("Result", LocalDate.of(2024, 5, 15), LocalDate.of(2024, 5, 15)));

        recruitmentProcess = new RecruitmentProcess(true, phases);
        jobOpening.setupPhases(recruitmentProcess);

        applicationId = new ApplicationId("12345");
        date = new Date();
        pathApplicationFolder = "/path/to/application/folder";
        candidate = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName("name")
                .withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress(email1).build();

        application = new Application(applicationId, date, pathApplicationFolder, candidate, jobOpening);

        r1 = new Rank(12);
        r2 = new Rank(1);

        o1 = new Order1(application, r1);
        o2 = new Order1(application, r2);
    }


    @Test
    public void withNullRank() {
        boolean check;
        try {
            Order1 o1 = new Order1(application, null);
            check = true;
        } catch (Exception e) {
            check = false;
        }
        assertFalse(check);
    }

    @Test
    public void withNullApplication() {
        boolean check;
        try {
            Order1 o1 = new Order1(null, r1);
            check = true;
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertFalse(check);
    }

    @Test
    public void testEqualsWithSameOrder() {
        final boolean check = o1.equals(o1);
        assertTrue(check);
    }
    
    @Test
    public void testEqualsWithDifferentOrder() {
        final boolean check = o1.equals(o2);

        assertFalse(check);
    }

    @Test
    public void validTest() {
        boolean check;
        try {
            Order1 order = new Order1(application, r1);
            check = true;
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertTrue(check);
    }


    @Test
    public void validTest2() {
        boolean check;
        try {
            Order1 order = new Order1(application, r2);
            check = true;
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertTrue(check);
    }

}