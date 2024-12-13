package lapr4.jobs4u.jobopeningmanagement.domain;


public final class PhaseState {

    public static final String ONGOING = "ONGOING";

    public static final String NOT_ACTIVE = "NOT_ACTIVE";

    public static String[] phaseStates() {
        return new String[]{ONGOING, NOT_ACTIVE};
    }

}




