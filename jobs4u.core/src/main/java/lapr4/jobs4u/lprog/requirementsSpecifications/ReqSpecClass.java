package lapr4.jobs4u.lprog.requirementsSpecifications;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.lprog.interviewModels.ErrorListener;
import lapr4.jobs4u.pluginmanagement.application.PluginImporter;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ReqSpecClass implements PluginImporter {

    @Override
    public boolean checkPlugin(String path) throws IOException {
        //Path Repository Root
        requirementSpecificationLexer lexer = new requirementSpecificationLexer(CharStreams.fromFileName(path));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        requirementSpecificationParser parser = new requirementSpecificationParser(tokens);

        ErrorListener errorListener = new ErrorListener();

        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.start();

        return errorListener.isValid();
    }

    @Override
    public String generateTemplate(String path, JobReference jobReference, Application application) throws IOException {
        String destinationDirectoryPath = "jobs4u.core/src/main/java/lapr4/jobs4u/pluginmanagement/domain/GeneratedRequirementTemplates/" + jobReference;
        String finalFile = "RequirementsAnswers_" + application.applicationId().toString() + ".txt";
        try {
            File destDir = new File(destinationDirectoryPath);
            if (!destDir.exists())
                destDir.mkdirs();

            // Copy the file to the destination directory
            Files.copy(Path.of(path),
                    Path.of(destinationDirectoryPath, finalFile), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Failed to generate template: " + e.getMessage());
        }

        return destinationDirectoryPath + "/" + finalFile;
    }

    @Override
    public boolean evaluateRequirement(String pluginPath, String answersPath) throws IOException {

        requirementSpecificationLexer lexer = new requirementSpecificationLexer(CharStreams.fromFileName(pluginPath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        requirementSpecificationParser parser = new requirementSpecificationParser(tokens);
        ParseTree tree = parser.start();
        ParseTreeWalker walker = new ParseTreeWalker();
        RequirementsListener listener = new RequirementsListener();
        walker.walk(listener, tree);

        List<String> solutions = listener.getNonMul();
        Map<String, List<String>> multipleQuestionsSolutions = listener.getMul();


        lexer = new requirementSpecificationLexer(CharStreams.fromFileName(answersPath));
        tokens = new CommonTokenStream(lexer);
        parser = new requirementSpecificationParser(tokens);
        tree = parser.start();
        walker = new ParseTreeWalker();
        listener = new RequirementsListener();
        walker.walk(listener, tree);

        List<String> userAnswers = listener.getNonMul();
        Map<String, List<String>> userMultipleQuestions = listener.getMul();

        return getPass(solutions, userAnswers) && getPassMult(multipleQuestionsSolutions, userMultipleQuestions);

    }


    public static boolean getPass(List<String> correctAnswers, List<String> userAnswers) {
        for (int i = 0; i < correctAnswers.size(); i++) {
            if (!Objects.equals(correctAnswers.get(i), userAnswers.get(i)))
                return false;
        }

        return true;
    }
    public static boolean getPassMult(Map<String, List<String>> correctMul, Map<String, List<String>> userMul) {

        for (Map.Entry<String, List<String>> entry : userMul.entrySet()) {
            String key = entry.getKey();

            if (correctMul.containsKey(key)) {
                List<String> userAnswerList = entry.getValue();
                List<String> correctAnswerList = correctMul.get(key);

                for (int i = 0; i < correctAnswerList.size(); i++) {
                    if (correctAnswerList.size() != userAnswerList.size() && !userAnswerList.contains(correctAnswerList.get(i)) ) {
                        return false;
                    }
                }
            }else return false;
        }

        return true;
    }


}
