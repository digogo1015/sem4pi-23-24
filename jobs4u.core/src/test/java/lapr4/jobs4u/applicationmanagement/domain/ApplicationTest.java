//package lapr4.jobs4u.applicationmanagement.domain;
//
//import eapli.framework.infrastructure.authz.domain.model.*;
//import lapr4.jobs4u.candidatemanagement.domain.Candidate;
//import lapr4.jobs4u.candidatemanagement.domain.CandidateBuilder;
//import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
//import lapr4.jobs4u.usermanagement.domain.UserRoles;
//import org.junit.jupiter.api.Test;
//
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ApplicationTest {
//    Candidate candidate = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
//            ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
//            ("aaa@aaaa.com").build();
//    Candidate candidate1 = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
//            ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
//            ("bbb@aaaa.com").build();
//    Candidate candidate2 = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
//            ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
//            ("ccc@aaaa.com").build();
//    JobOpening jobOpening = null;
//    Application application = new ApplicationBuilder().withApplicationId(new ApplicationId("id"))
//            .withDate(new Date())
//            .withPathApplicationFolder("path")
//            .withCandidate(candidate)
//            .withJobOpening(jobOpening)
//            .build();
//    Application application1 = new ApplicationBuilder().withApplicationId(new ApplicationId("id"))
//            .withDate(new Date())
//            .withPathApplicationFolder("path")
//            .withCandidate(candidate1)
//            .withJobOpening(jobOpening)
//            .build();
//    Application application2 = new ApplicationBuilder().withApplicationId(new ApplicationId("id"))
//            .withDate(new Date())
//            .withPathApplicationFolder("path")
//            .withCandidate(candidate2)
//            .withJobOpening(jobOpening)
//            .build();
//
//    public static SystemUser exampleUser(final String email, final Role... roles) {
//        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
//
//        return userBuilder.with(email, "Password1+", "Exemplo", "Exemplo", email).withRoles(roles).build();
//    }
//
//    private SystemUser getNewCandidateUser() {
//        return exampleUser("test@test.com", UserRoles.CANDIDATE);
//    }
//
//    @Test
//    void candidate() {
//        assertEquals(candidate, application.candidate());
//        assertNotEquals(candidate, application1.candidate());
//        assertNotEquals(candidate, application2.candidate());
//        assertNotEquals(candidate1, application.candidate());
//        assertEquals(candidate1, application1.candidate());
//        assertNotEquals(candidate1, application2.candidate());
//        assertNotEquals(candidate2, application.candidate());
//        assertNotEquals(candidate2, application1.candidate());
//        assertEquals(candidate2, application2.candidate());
//    }
//
//    @Test
//    void sameAs() {
//        assertTrue(application.sameAs(application));
//        assertFalse(application.sameAs(candidate));
//        assertTrue(application1.sameAs(application));
//        assertFalse(application1.sameAs(candidate));
//        assertTrue(application2.sameAs(application));
//        assertFalse(application2.sameAs(candidate));
//    }
//
//    @Test
//    void applicationId() {
//        assertEquals(application.applicationId(), application1.applicationId());
//        assertEquals(application.applicationId(), application2.applicationId());
//        assertEquals(application1.applicationId(), application2.applicationId());
//    }
//
//    @Test
//    void identity() {
//        assertEquals(application.identity(), application1.identity());
//        assertEquals(application.identity(), application2.identity());
//        assertEquals(application1.identity(), application2.identity());
//    }
//}
//package lapr4.jobs4u.applicationmanagement.domain;
//
//import eapli.framework.general.domain.model.Description;
//import eapli.framework.infrastructure.authz.domain.model.*;
//import lapr4.jobs4u.candidatemanagement.domain.Candidate;
//import lapr4.jobs4u.candidatemanagement.domain.CandidateBuilder;
//import lapr4.jobs4u.customermanagement.domain.Customer;
//import lapr4.jobs4u.customermanagement.domain.CustomerBuilder;
//import lapr4.jobs4u.jobopeningmanagement.domain.*;
//import lapr4.jobs4u.usermanagement.domain.UserRoles;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ApplicationTest {
//    private SystemUser getNewCustomerUser() {
//        return exampleUser("test@test.com", UserRoles.CUSTOMER);
//    }
//
//    Candidate candidate = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
//            ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
//            ("aaa@aaaa.com").build();
//    Candidate candidate1 = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
//            ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
//            ("bbb@aaaa.com").build();
//    Candidate candidate2 = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
//            ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
//            ("ccc@aaaa.com").build();
//    JobOpening jobOpening = null;
//    Application application = new ApplicationBuilder().withApplicationId(new ApplicationId("id"))
//            .withDate(new Date())
//            .withPathApplicationFolder("path")
//            .withCandidate(candidate)
//            .withJobOpening(jobOpening)
//            .build();
//    Application application1 = new ApplicationBuilder().withApplicationId(new ApplicationId("id"))
//            .withDate(new Date())
//            .withPathApplicationFolder("path")
//            .withCandidate(candidate1)
//            .withJobOpening(jobOpening)
//            .build();
//    Application application2 = new ApplicationBuilder().withApplicationId(new ApplicationId("id"))
//            .withDate(new Date())
//            .withPathApplicationFolder("path")
//            .withCandidate(candidate2)
//            .withJobOpening(jobOpening)
//            .build();
//
//    public static SystemUser exampleUser(final String email, final Role... roles) {
//        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
//
//        return userBuilder.with(email, "Password1+", "Exemplo", "Exemplo", email).withRoles(roles).build();
//    }
//
//    private SystemUser getNewCandidateUser() {
//        return exampleUser("test@test.com", UserRoles.CANDIDATE);
//    }
//
//    @Test
//    void candidate() {
//        assertEquals(candidate, application.candidate());
//        assertNotEquals(candidate, application1.candidate());
//        assertNotEquals(candidate, application2.candidate());
//        assertNotEquals(candidate1, application.candidate());
//        assertEquals(candidate1, application1.candidate());
//        assertNotEquals(candidate1, application2.candidate());
//        assertNotEquals(candidate2, application.candidate());
//        assertNotEquals(candidate2, application1.candidate());
//        assertEquals(candidate2, application2.candidate());
//    }
//
//    @Test
//    void sameAs() {
//        assertTrue(application.sameAs(application));
//        assertFalse(application.sameAs(candidate));
//        assertTrue(application1.sameAs(application));
//        assertFalse(application1.sameAs(candidate));
//        assertTrue(application2.sameAs(application));
//        assertFalse(application2.sameAs(candidate));
//    }
//
//    @Test
//    void applicationId() {
//        assertEquals(application.applicationId(), application1.applicationId());
//        assertEquals(application.applicationId(), application2.applicationId());
//        assertEquals(application1.applicationId(), application2.applicationId());
//    }
//
//    @Test
//    void identity() {
//        assertEquals(application.identity(), application1.identity());
//        assertEquals(application.identity(), application2.identity());
//        assertEquals(application1.identity(), application2.identity());
//    }
//}