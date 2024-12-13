package lapr4.jobs4u.pluginmanagement.domain;

public class PlugInTest {

    private final String aDesignation = "PLUGIN1";
    private final String anotherDesignation = "PLUGIN2";

    /*@Test
    public void ensurePlugInEqualsPassesForTheSamePlugin() throws Exception {

        final PlugIn aPlugin = new PluginBuilder().withDesignation(Designation.valueOf("IGUAL")).
                withDescription(Description.valueOf("descrição")).withType(PluginType.INTERVIEW_MODEL)
                .withClass(FQClassName.valueOf("path")).build();

        final PlugIn anotherPlugin = new PluginBuilder().withDesignation(Designation.valueOf("IGUAL")).
                withDescription(Description.valueOf("descrição")).withType(PluginType.INTERVIEW_MODEL)
                .withClass(FQClassName.valueOf("path")).build();


        final boolean expected = aPlugin.equals(anotherPlugin);

        assertTrue(expected);
    }


    @Test
    public void ensurePluginEqualsFailsForDifferentDesigantion() throws Exception {
        final PlugIn aPlugin = new PluginBuilder().withDesignation(Designation.valueOf(aDesignation)).
                withDescription(Description.valueOf("descrição")).withType(PluginType.INTERVIEW_MODEL)
                .withClass(FQClassName.valueOf("path")).build();

        final PlugIn anotherPlugin = new PluginBuilder().withDesignation(Designation.valueOf(anotherDesignation)).
                withDescription(Description.valueOf("descrição")).withType(PluginType.INTERVIEW_MODEL)
                .withClass(FQClassName.valueOf("path")).build();

        final boolean expected = aPlugin.equals(anotherPlugin);

        assertFalse(expected);

    }

    @Test
    public void ensurePluginEqualsFailsForDifferenteObjectTypes() throws Exception {

        final PlugIn aPlugin = new PluginBuilder().withDesignation(Designation.valueOf(aDesignation)).
                withDescription(Description.valueOf("descrição")).withType(PluginType.INTERVIEW_MODEL)
                .withClass(FQClassName.valueOf("path2")).build();

        final PlugIn anotherPlugin = new PluginBuilder().withDesignation(Designation.valueOf(anotherDesignation)).
                withDescription(Description.valueOf("descrição")).withType(PluginType.REQUIREMENTS_SPECIFICATION)
                .withClass(FQClassName.valueOf("path1")).build();

        @SuppressWarnings("unlikely-arg-type") final boolean expected = aPlugin.equals(anotherPlugin);

        assertFalse(expected);
    }

    @Test
    public void ensurePluginIsTheSameAsItsInstance() throws Exception {

        final PlugIn aPlugin = new PluginBuilder().withDesignation(Designation.valueOf(aDesignation)).
                withDescription(Description.valueOf("descrição")).withType(PluginType.INTERVIEW_MODEL)
                .withClass(FQClassName.valueOf("path2")).build();

        final boolean expected = aPlugin.sameAs(aPlugin);

        assertTrue(expected);
    }


    @Test
    public void ensureTwoPluginsWithDifferentDesignationAreNotTheSame() throws Exception {

        final PlugIn aPlugin = new PluginBuilder().withDesignation(Designation.valueOf(aDesignation)).
                withDescription(Description.valueOf("descrição")).withType(PluginType.INTERVIEW_MODEL)
                .withClass(FQClassName.valueOf("path2")).build();

        final PlugIn anotherPlugin = new PluginBuilder().withDesignation(Designation.valueOf(anotherDesignation)).
                withDescription(Description.valueOf("descrição")).withType(PluginType.REQUIREMENTS_SPECIFICATION)
                .withClass(FQClassName.valueOf("path1")).build();

        final boolean expected = aPlugin.sameAs(anotherPlugin);

        assertFalse(expected);
    }*/

}