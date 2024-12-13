package lapr4.jobs4u.applicationmanagement.domain;

public final class ApplicationStates {

    public static final String REJECTED = "REJECTED";
    public static final String ACCEPTED = "ACCEPTED";
    public static final String NOT_KNOWN = "NOT_KNOWN";

    public static String[] applicationStates() {
        return new String[]{REJECTED, ACCEPTED, NOT_KNOWN};
    }
}
