package lapr4.jobs4u.candidatemanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.*;
import lapr4.jobs4u.usermanagement.domain.UserRoles;
import org.junit.Test;

import static org.junit.Assert.*;

public class CandidateTest {

    private final String email1 = "test1@test.com";
    private final String email2 = "test2@test.com";

    public static SystemUser exampleUser(final String email, final Role... roles) {
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());

        return userBuilder.with(email, "Password1+", "Exemplo", "Exemplo", email).withRoles(roles).build();
    }

    private SystemUser getNewCandidateUser() {
        return exampleUser("test@test.com", UserRoles.CANDIDATE);
    }

    @Test
    public void ensureCandidateEqualsPassesForTheSameEmail() throws Exception {
        final Candidate candidate = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
                ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
                (email1).build();

        final Candidate candidate1 = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
                ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
                (email1).build();

        final boolean expected = candidate.equals(candidate1);

        assertTrue(expected);
    }

    @Test
    public void ensureCandidateEqualsPassesForDifferentSameEmail() throws Exception {
        final Candidate candidate = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
                ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
                (email1).build();

        final Candidate candidate1 = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
                ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
                (email2).build();

        final boolean expected = candidate.equals(candidate1);

        assertFalse(expected);
    }

    @Test
    public void ensureCandidateUserEqualsFailsForDifferentObjectTypes() throws Exception {
        final Candidate candidate = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
                ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
                (email1).build();

        @SuppressWarnings("unlikely-arg-type") final boolean expected = candidate.equals(getNewCandidateUser());

        assertFalse(expected);
    }

    @Test
    public void ensureCandidateUserIsTheSameAsItsInstance() throws Exception {
        final Candidate candidate = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
                ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
                (email1).build();

        final boolean expected = candidate.sameAs(candidate);

        assertTrue(expected);
    }


    @Test
    public void ensureTwoCandidateUserWithDifferentEmailsAreNotTheSame() throws Exception {
        final Candidate candidate = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
                ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
                (email1).build();

        final Candidate candidate1 =new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
                ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
                (email2).build();

        final boolean expected = candidate.sameAs(candidate1);

        assertFalse(expected);
    }

    @Test
    public void createCandidateWithNullFirstName() throws Exception {
        boolean check = true;
        try {
            Candidate candidate = new CandidateBuilder().withCandidateFirstName(null).withCandidateLastName
                    ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
                    (email1).build();

        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertFalse(check);
    }

    @Test
    public void createCandidateWithNullLastName() throws Exception {
        boolean check = true;
        try {
            Candidate candidate = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
                    (null).withSystemUser(getNewCandidateUser()).withPhoneNumber("123123123").withEmailAddress
                    (email1).build();

        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertFalse(check);
    }

    @Test
    public void createCandidateWithNullPhoneNumber() throws Exception {
        boolean check = true;
        try {
            Candidate candidate = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
                    ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber(null).withEmailAddress
                    (email1).build();

        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertFalse(check);
    }

    @Test
    public void createCandidateWithInvalidPhoneNumber() throws Exception {
        boolean check = true;
        try {
            Candidate candidate = new CandidateBuilder().withCandidateFirstName("name").withCandidateLastName
                    ("name").withSystemUser(getNewCandidateUser()).withPhoneNumber("123").withEmailAddress
                    (email1).build();

        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertFalse(check);
    }
}