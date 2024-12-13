package lapr4.jobs4u.notificationmanagement.domain;

public final class NotificationType {

    public static final String PHASE_CHANGE = "PHASE_CHANGE";
    public static final String APPLICATION_RESULTS = "APPLICATION_RESULTS";
    public static final String APPLICATION_CHANGE = "APPLICATION_CHANGE";

    public static String[] applicationStates() {
        return new String[]{PHASE_CHANGE, APPLICATION_RESULTS, APPLICATION_CHANGE};
    }
}
