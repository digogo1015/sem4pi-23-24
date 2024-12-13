package lapr4.jobs4u.jobopeningmanagement.domain;

public final class JobOpeningStates {

    public static final String UNCOMPLETED = "UNCOMPLETED";

    public static final String COMPLETED = "COMPLETED";

    public static String[] jobstates() {
        return new String[]{UNCOMPLETED, COMPLETED};
    }

}
