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
import lapr4.jobs4u.rankmanagement.domain.Ranking;
import lapr4.jobs4u.usermanagement.domain.UserRoles;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RankingTest {

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


    private JobReference jobReference1;
    private JobReference jobReference2;
    private eapli.framework.general.domain.model.Description description;
    private lapr4.jobs4u.jobopeningmanagement.domain.Address address;
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
    private ApplicationId applicationId2;
    private Date date;
    private String pathApplicationFolder;
    private Candidate candidate;
    private Application application;
    private Application application2;
    private Order1 o1;
    private Order1 o2;
    private Order1 o3;
    private Order1 o4;
    private Rank r1;
    private Rank r2;
    private Rank r3;
    private Rank r4;


    @Before
    public void setUp() throws IllegalAccessException {
        jobReference1 = new JobReference("ISEP", "123");
        jobReference2 = new JobReference("FEUP", "333");
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

        jobOpening = new JobOpening(jobReference1, description, address, jobOpeningMode, jobTitle, jobOpeningState,
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
        applicationId2 = new ApplicationId("5555");

        date = new Date();
        pathApplicationFolder = "/path/to/application/folder";
        candidate = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName("name")
                .withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress(email1).build();

        application = new Application(applicationId, date, pathApplicationFolder, candidate, jobOpening);
        application2 = new Application(applicationId2, date, pathApplicationFolder, candidate, jobOpening);

        r1 = new Rank(12);
        r2 = new Rank(1);
        r3 = new Rank(4);
        r4 = new Rank(43);

        o1 = new Order1(application, r1);
        o2 = new Order1(application, r2);
        o3 = new Order1(application2, r3);
        o4 = new Order1(application2, r4);
    }


    @Test
    public void createRankingWithNullJobReference() {
        boolean check;
        List<Order1> list = new ArrayList<>();

        try {
            list.add(o1);
            final Ranking ranking1 = new Ranking(null, list);
            check = true;
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertFalse(check);
    }


    @Test
    public void createRankingWithNullRanking() {
        boolean check;

        try {
            final Ranking ranking1 = new Ranking(jobReference1, null);
            check = true;
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertFalse(check);
    }


    @Test
    public void createValidRanking1() {
        boolean check;
        List<Order1> list = new ArrayList<>();

        try {
            list.add(o2);
            list.add(o1);
            list.add(o3);
            final Ranking ranking1 = new Ranking(jobReference1, list);
            check = true;
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertTrue(check);
    }


    @Test
    public void createValidRanking2() {
        boolean check;
        List<Order1> list = new ArrayList<>();

        try {
            list.add(o2);
            list.add(o1);
            list.add(o3);
            list.add(o4);
            final Ranking ranking1 = new Ranking(jobReference1, list);
            check = true;
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertTrue(check);
    }

    @Test
    public void createValidRanking3() {
        boolean check;
        List<Order1> list = new ArrayList<>();

        try {
            list.add(o2);
            final Ranking ranking1 = new Ranking(jobReference1, list);
            check = true;
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertTrue(check);
    }

    @Test
    public void createRankingWithEmptyList() {
        boolean check;
        List<Order1> list = new ArrayList<>();

        try {
            final Ranking ranking1 = new Ranking(jobReference1, list);
            check = true;
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertFalse(check);
    }
}


