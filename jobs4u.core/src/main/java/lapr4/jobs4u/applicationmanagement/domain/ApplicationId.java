package lapr4.jobs4u.applicationmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class ApplicationId implements ValueObject, Comparable<ApplicationId> {

    private static final long serialVersionUID = 1L;

    private String applicationId;

    public String applicationId() {
        return applicationId;
    }

    public ApplicationId(final String applicationId) {
        this.applicationId = applicationId;
    }

    protected ApplicationId() {
        // for ORM
    }

    public static ApplicationId valueOf(final String applicationId) {
        return new ApplicationId(applicationId);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApplicationId)) {
            return false;
        }

        final ApplicationId that = (ApplicationId) o;
        return this.applicationId.equals(that.applicationId);
    }

    @Override
    public int hashCode() {
        return this.applicationId.hashCode();
    }

    @Override
    public String toString() {
        return this.applicationId;
    }

    @Override
    public int compareTo(final ApplicationId arg0) {
        return applicationId.compareTo(arg0.applicationId);
    }
}
