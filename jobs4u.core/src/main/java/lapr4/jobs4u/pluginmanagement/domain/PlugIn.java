/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package lapr4.jobs4u.pluginmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Version;
import eapli.framework.general.domain.model.*;
import lapr4.jobs4u.pluginmanagement.application.PluginImporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

@Entity
public class PlugIn implements AggregateRoot<Designation> {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LogManager.getLogger(PlugIn.class);

    @Version
    private Long version;

    @EmbeddedId
    private Designation designation;

    private Description description;

    private FQClassName className;

    private TypeOfSomething pluginType;

    private String filePath;
    private String templateFilePath;


    public PlugIn(final Designation designation, final Description description, final FQClassName classname, final TypeOfSomething pluginType, final String filePath,final String templateFilePath) {
        if (description == null || designation == null || classname == null || pluginType == null || filePath == null || templateFilePath == null) {
            throw new IllegalArgumentException();
        }
        this.description = description;
        this.designation = designation;
        this.className = classname;
        this.pluginType = pluginType;
        this.filePath = filePath;
        this.templateFilePath = templateFilePath;
    }

    protected PlugIn() {
    }

    public Description description() {
        return this.description;
    }

    public FQClassName classname() {
        return this.className;
    }

    public TypeOfSomething pluginType() {
        return this.pluginType;
    }

    public String filePath() {
        return this.filePath;
    }

    public String templateFilePath() {
        return this.templateFilePath;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public Designation designation() {
        return identity();
    }

    @Override
    public Designation identity() {
        return this.designation;
    }

    @Override
    public String toString() {
        return designation + ": " + description;
    }

    public PluginImporter buildImporter() {
        try {
            return (PluginImporter) Class.forName(className.toString()).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | IllegalArgumentException
                 | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            LOGGER.error("Unable to dynamically load the Plugin", ex);
            throw new IllegalStateException("Unable to dynamically load the Plugin: " + className.toString(), ex);
        }
    }
}
