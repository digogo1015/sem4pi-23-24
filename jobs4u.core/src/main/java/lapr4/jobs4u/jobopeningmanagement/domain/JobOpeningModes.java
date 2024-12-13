package lapr4.jobs4u.jobopeningmanagement.domain;

public final class JobOpeningModes {

    public static final String REMOTE = "REMOTE";

    public static final String HYBRID = "HYBRID";
    public static final String ONSITE = "ONSITE";

    public static String[] modeTypes() {
        return new String[]{REMOTE, HYBRID, ONSITE};
    }

}
