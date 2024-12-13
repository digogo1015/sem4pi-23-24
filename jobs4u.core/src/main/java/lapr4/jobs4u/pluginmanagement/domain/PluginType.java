package lapr4.jobs4u.pluginmanagement.domain;

public final class PluginType {

    public static final TypeOfSomething INTERVIEW_MODEL = TypeOfSomething.valueOf("INTERVIEW_MODEL");

    public static final TypeOfSomething REQUIREMENTS_SPECIFICATION = TypeOfSomething.valueOf("REQUIREMENTS_SPECIFICATION");

    public static TypeOfSomething[] pluginsTypes() {
        return new TypeOfSomething[]{INTERVIEW_MODEL, REQUIREMENTS_SPECIFICATION};
    }

}
