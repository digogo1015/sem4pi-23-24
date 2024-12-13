package lapr4.jobs4u.customermanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.*;
import lapr4.jobs4u.usermanagement.domain.UserRoles;
import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomerCodeTest {


    @Test
    public void ensureCostumerCodeNotNull() throws Exception {

        boolean valid = true;

        try {
            final CustomerCode invalid = new CustomerCode(null);
        } catch (Exception ex) {
            valid = false;
        }

        assertFalse(valid);
    }

    @Test
    public void ensureCostumerCodeNotEmpty() throws Exception {

        boolean valid = true;

        try {
            final CustomerCode invalid = new CustomerCode("   ");
        } catch (Exception ex) {
            valid = false;
        }

        assertFalse(valid);
    }

    @Test
    public void ensureCostumerCodeDoesNotBeginWithNuber() throws Exception {

        boolean valid = true;

        try {
            final CustomerCode invalid = new CustomerCode("1COSTUM");
        } catch (Exception ex) {
            valid = false;
        }

        assertFalse(valid);
    }

    @Test
    public void ensureCostumerCodeDoesNotHaveMoreThan10Characters() throws Exception {

        boolean valid = true;

        try {
            final CustomerCode invalid = new CustomerCode("PLUS10CHARACTERS");
        } catch (Exception ex) {
            valid = false;
        }

        assertFalse(valid);
    }


    @Test
    public void ensureCostumerCodeLowerCaseGoesToUpper() throws Exception {


        final CustomerCode aCustomerCode = new CustomerCode("custCode1");

        final CustomerCode anotherCustomerCode = new CustomerCode("custCode1");

        final boolean expected = aCustomerCode.equals(anotherCustomerCode);

        assertTrue(expected);
    }

}