package lapr4.jobs4u.jobopeningmanagement.domain;

public enum PhaseNames {
    APPLICATION("Application"),
    SCREENING("Screening"),
    INTERVIEW("Interview"),
    ANALYSIS("Analysis"),
    RESULT("Result");

    final String name;

    PhaseNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
