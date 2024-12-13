package lapr4.jobs4u.pluginmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.util.Objects;


@Embeddable
public class TypeOfSomething implements ValueObject {

    private static final long serialVersionUID = 1L;

    private String typeName;

    private TypeOfSomething(final String name) {
        Preconditions.nonEmpty(name);

        typeName = name;
    }

    protected TypeOfSomething() {
    }

    @Override
    public String toString() {
        return typeName;
    }

    public static TypeOfSomething valueOf(final String name) {
        return new TypeOfSomething(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeOfSomething that = (TypeOfSomething) o;
        return Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName);
    }
}
