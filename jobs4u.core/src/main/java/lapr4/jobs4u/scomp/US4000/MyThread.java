package lapr4.jobs4u.scomp.US4000;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

public class MyThread implements Runnable {

    private Map<String, WordInfo> wordCount;

    private String filePath;

    private Object myLock;

    public MyThread(Map<String, WordInfo> wordCount, String filePath, Object myLock) {
        this.wordCount = wordCount;
        this.filePath = filePath;
        this.myLock = myLock;
    }

    @Override
    public void run() {
        File file = new File(filePath);

        FileReader fileReader;
        BufferedReader bufferedReader;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase();
                        synchronized (myLock) {
                            WordInfo wordInfo = wordCount.getOrDefault(word, new WordInfo());
                            wordInfo.incrementWordCount();
                            wordInfo.addFileName(file.getName());
                            wordCount.put(word, wordInfo);
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }
}
