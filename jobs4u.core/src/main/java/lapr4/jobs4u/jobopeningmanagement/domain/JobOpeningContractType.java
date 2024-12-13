package lapr4.jobs4u.jobopeningmanagement.domain;

public final class JobOpeningContractType {

    public static final String FULL_TIME = "FULL_TIME";

    public static final String PART_TIME = "PART_TIME";

    public static String[] contractTypes() {
        return new String[]{FULL_TIME, PART_TIME};
    }

}
