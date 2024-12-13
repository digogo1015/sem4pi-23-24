package lapr4.jobs4u.notificationmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.util.Objects;


@Embeddable
public class domain implements ValueObject {

    private static final long serialVersionUID = 1L;

    private String typeName;

    private domain(final String name) {
        Preconditions.nonEmpty(name);

        typeName = name;
    }

    protected domain() {
    }

    @Override
    public String toString() {
        return typeName;
    }

    public static domain valueOf(final String name) {
        return new domain(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        domain that = (domain) o;
        return Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName);
    }
}
