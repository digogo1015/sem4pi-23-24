package lapr4.jobs4u.customermanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.*;
import lapr4.jobs4u.usermanagement.domain.UserRoles;
import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomerTest {

    private final String aCustomerCode = "COMPANY1";
    private final String anotherCustomerCode = "COMPANY2";

    public static SystemUser exampleUser(final String email, final Role... roles) {
        // should we load from spring context?
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());

        return userBuilder.with(email, "Password1+", "Exemplo", "Exemplo", email).withRoles(roles).build();
    }

    private SystemUser getNewCustomerUser() {
        return exampleUser("test@test.com", UserRoles.CUSTOMER);
    }

    @Test
    public void ensureCostumerEqualsPassesForTheSameCustomerCode() throws Exception {

        final Customer aCustomer = new CustomerBuilder().withCustomerCode("IGUAL").withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        final Customer anotherCustomer = new CustomerBuilder().withCustomerCode("IGUAL").withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        final boolean expected = aCustomer.equals(anotherCustomer);

        assertTrue(expected);
    }


    @Test
    public void ensureCustomerEqualsFailsForDifferentCustomerCode() throws Exception {
        final Customer aCustomer = new CustomerBuilder().withCustomerCode(aCustomerCode).withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        final Customer anotherCustomer = new CustomerBuilder().withCustomerCode(anotherCustomerCode).withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        final boolean expected = aCustomer.equals(anotherCustomer);

        assertFalse(expected);

    }

    @Test
    public void ensureCustomerUserEqualsFailsForDifferenteObjectTypes() throws Exception {

        final Customer aCustomer = new CustomerBuilder().withCustomerCode(anotherCustomerCode).withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        @SuppressWarnings("unlikely-arg-type") final boolean expected = aCustomer.equals(getNewCustomerUser());

        assertFalse(expected);
    }

    @Test
    public void ensureCustomerUserIsTheSameAsItsInstance() throws Exception {
        final Customer aCustomer = new CustomerBuilder().withCustomerCode(anotherCustomerCode).withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        final boolean expected = aCustomer.sameAs(aCustomer);

        assertTrue(expected);
    }


    @Test
    public void ensureTwoCustomerUserWithDifferentCustomerCodesAreNotTheSame() throws Exception {

        final Customer aCustomer = new CustomerBuilder().withCustomerCode(aCustomerCode).withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        final Customer anotherCustomer = new CustomerBuilder().withCustomerCode(anotherCustomerCode).withSystemUser(getNewCustomerUser())
                .withAddress("street", "city", "state").withManager(getNewCustomerUser()).build();

        final boolean expected = aCustomer.sameAs(anotherCustomer);

        assertFalse(expected);
    }

}