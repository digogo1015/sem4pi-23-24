package lapr4.jobs4u.lprog.interviewModels;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.pluginmanagement.application.PluginImporter;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class IntModClass implements PluginImporter {

    @Override
    public boolean checkPlugin(String path) throws IOException {
        //Path Repository Root
        interviewModelLexer lexer = new interviewModelLexer(CharStreams.fromFileName(path));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        interviewModelParser parser = new interviewModelParser(tokens);

        ErrorListener errorListener = new ErrorListener();

        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.start();

        //int totalMarks = parser.getTotalMarks();
        //&& (totalMarks == 0 || totalMarks == 100)


        return errorListener.isValid();
    }

    @Override
    public String generateTemplate(String path, JobReference jobReference, Application application) throws IOException {
        String destinationDirectoryPath = "jobs4u.core/src/main/java/lapr4/jobs4u/pluginmanagement/domain/GeneratedInterviewTemplates/" + jobReference;
        String finalFile = "InterviewAnswers_" + application.applicationId().toString() + ".txt";
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
    public Integer evaluateInterviewModel(String pluginPath, String answersPath) throws IOException {

        interviewModelLexer lexer = new interviewModelLexer(CharStreams.fromFileName(pluginPath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        interviewModelParser parser = new interviewModelParser(tokens);
        ParseTree tree = parser.start();
        VisitorImpl visitor = new VisitorImpl();
        visitor.visit(tree);

        Map<String, List<Answer>> multipleQuestionsSolutions = visitor.getMul();


        lexer = new interviewModelLexer(CharStreams.fromFileName(answersPath));
        tokens = new CommonTokenStream(lexer);
        parser = new interviewModelParser(tokens);
        tree = parser.start();
        visitor = new VisitorImpl();
        visitor.visit(tree);

        Map<String, List<Answer>> userMultipleQuestions = visitor.getMul();


        return getScore(multipleQuestionsSolutions, userMultipleQuestions);

    }

    public static Integer getScore(Map<String, List<Answer>> correctMul, Map<String, List<Answer>> userMul) {
        Integer score = 0;

        for (Map.Entry<String, List<Answer>> entry : userMul.entrySet()) {
            String key = entry.getKey();
            List<Answer> userAnswerList = entry.getValue();

            if (correctMul.containsKey(key)) {
                List<Answer> correctAnswerList = correctMul.get(key);

                for (int i = 0; i < correctAnswerList.size(); i++) {
                    if (i < userAnswerList.size() && Objects.equals(correctAnswerList.get(i).answerText, userAnswerList.get(i).answerText)) {
                        score += correctAnswerList.get(i).mark;
                    }
                }
            }
        }

        return score;
    }

}
