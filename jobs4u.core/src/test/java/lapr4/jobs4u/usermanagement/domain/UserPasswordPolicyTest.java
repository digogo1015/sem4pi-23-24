package lapr4.jobs4u.usermanagement.domain;

import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserPasswordPolicyTest {

    private final PasswordPolicy policy = new UserPasswordPolicy();

    @Test
    public void ensurePasswordIsNotNull() throws Exception {
        assertFalse(policy.isSatisfiedBy(null));
    }

    @Test
    public void ensurePasswordIsNotEmpty() throws Exception {
        assertFalse(policy.isSatisfiedBy(""));
    }

    @Test
    public void ensurePasswordIsNotWhiteSpaces() throws Exception {
        assertFalse(policy.isSatisfiedBy("   "));
    }

    @Test
    public void ensurePasswordIsNotValid() throws Exception {
        assertFalse(policy.isSatisfiedBy("Password1"));
        assertFalse(policy.isSatisfiedBy("Password+"));
        assertFalse(policy.isSatisfiedBy("password1+"));
        assertFalse(policy.isSatisfiedBy("Pa1+"));
    }

    @Test
    public void ensurePasswordIsValid() throws Exception {
        assertTrue(policy.isSatisfiedBy("Password1+"));
        }
}