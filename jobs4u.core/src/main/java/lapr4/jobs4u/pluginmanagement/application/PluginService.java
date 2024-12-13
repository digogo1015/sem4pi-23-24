package lapr4.jobs4u.pluginmanagement.application;


import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationId;
import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.pluginmanagement.domain.PlugIn;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PluginService {

    private final ApplicationRepository applicationRepository = PersistenceContext.repositories().applications();


    public String generateTemplate(PlugIn plugin, JobReference jobReference, Application application) throws IOException {
        final var importer = plugin.buildImporter();
        return importer.generateTemplate(plugin.templateFilePath(), jobReference, application);
    }

    public boolean checkInterviewFile(PlugIn plugin, Application application) throws IOException {
        final var importer = plugin.buildImporter();
        return importer.checkPlugin(application.interview().interviewAnswerPath());
    }

    public List<ApplicationId> checkInterviewFiles(PlugIn plugin, List<Application> applications) throws IOException {
        List<ApplicationId> invalidApplications = new ArrayList<>();

        for (Application application : applications) {
            if (!checkInterviewFile(plugin, application)) {
                application.interview().defineInterviewAnswerPath("invalid");
                invalidApplications.add(application.applicationId());
            }
        }
        return invalidApplications;
    }

    public boolean checkRequirementFile(PlugIn plugin, Application application) throws IOException {
        final var importer = plugin.buildImporter();
        return importer.checkPlugin(application.pathApplicationAnswerFile());
    }

    public List<ApplicationId> checkRequirementsFiles(PlugIn plugin, List<Application> applications) throws IOException {
        List<ApplicationId> invalidApplications = new ArrayList<>();

        for (Application application : applications) {
            if (Objects.equals(application.pathApplicationAnswerFile(), "invalid")) {
                invalidApplications.add(application.applicationId());
                continue;
            }
            if (!checkRequirementFile(plugin, application)) {
                application.definePathApplicationAnswerFile("invalid");
                applicationRepository.save(application);
                invalidApplications.add(application.applicationId());
            }
        }
        return invalidApplications;
    }
}
