package lapr4.jobs4u.pluginmanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.*;


public class PluginBuilder implements DomainFactory<PlugIn> {

    private Designation designation;
    private Description description;
    private FQClassName classname;
    private TypeOfSomething pluginType;
    private String pluginPath;
    private String templatePath;


    public PluginBuilder withDesignation(final Designation designation) {
        this.designation = designation;
        return this;
    }

    public PluginBuilder withDescription(final Description description) {
        this.description = description;
        return this;
    }

    public PluginBuilder withClass(final FQClassName classname) {
        this.classname = classname;
        return this;
    }

    public PluginBuilder withType(final TypeOfSomething pluginType) {
        this.pluginType = pluginType;
        return this;
    }

    public PluginBuilder withPath(final String path) {
        this.pluginPath = path;
        return this;
    }

    public PluginBuilder withTemplatePath(final String templatePath) {
        this.templatePath = templatePath;
        return this;
    }

    @Override
    public PlugIn build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        return new PlugIn(this.designation, this.description, this.classname, this.pluginType, this.pluginPath, this.templatePath);
    }
}
