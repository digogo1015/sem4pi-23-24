package lapr4.jobs4u.pluginmanagement.application;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;

import java.io.IOException;

public interface PluginImporter {

    boolean checkPlugin(String path) throws IOException;

    default String generateTemplate(String path, JobReference jobReference, Application application) throws IOException {
        return null;
    }

    default Integer evaluateInterviewModel(String pluginPath, String answersPath) throws IOException {
        return 0;
    }

    default boolean evaluateRequirement(String pluginPath, String answersPath) throws IOException {
        return false;
    }
}
