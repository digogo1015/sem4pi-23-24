package lapr4.jobs4u.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import jakarta.persistence.Embeddable;

@Embeddable
public class CustomerCode implements ValueObject, Comparable<CustomerCode> {

    private static final long serialVersionUID = 1L;

    private String code;

    public CustomerCode(final String customerCode) {
        if (StringPredicates.isNullOrWhiteSpace(customerCode) || (customerCode.length() > 10) || StringPredicates.containsDigit(String.valueOf(customerCode.charAt(0)))) {
            throw new IllegalArgumentException("Customer Code should neither be null, empty, have more than 10 characters or start with a number");
        }
        this.code = customerCode.toUpperCase();
    }

    protected CustomerCode() {
        // for ORM
    }

    public static CustomerCode valueOf(final String customerCode) {
        return new CustomerCode(customerCode);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomerCode)) {
            return false;
        }

        final CustomerCode that = (CustomerCode) o;
        return this.code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }

    @Override
    public String toString() {
        return this.code;
    }

    @Override
    public int compareTo(final CustomerCode arg0) {
        return code.compareTo(arg0.code);
    }
}
