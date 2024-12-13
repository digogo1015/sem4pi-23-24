package lapr4.jobs4u.notificationmanagement.domain;

public final class NotificationState {

    public static final String VIEWED = "VIEWED";
    public static final String NOT_VIEWED = "NOT_VIEWED";
    public static final String NOT_SENT = "NOT_SENT";
    public static final String SENT = "SENT";

    public static String[] applicationStates() {
        return new String[]{VIEWED, NOT_VIEWED, NOT_SENT, SENT};
    }
}
