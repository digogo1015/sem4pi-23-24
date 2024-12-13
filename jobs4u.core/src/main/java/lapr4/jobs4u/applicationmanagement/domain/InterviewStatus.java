package lapr4.jobs4u.applicationmanagement.domain;

public final class InterviewStatus {

    public static final String REALIZED = "REALIZED";

    public static final String NOT_REALIZED = "NOT_REALIZED";

    public static String[] interviewStatus() {
        return new String[]{REALIZED, NOT_REALIZED};
    }

}
