package lapr4.jobs4u.scomp.US4000;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class US4000 {

    private static final Map<String, WordInfo> wordCount = new HashMap<>();
    private static final Object myLock = new Object();

    public static List<String> CountWords(String path) {
        processCandidateFiles(path);
        return printTop20Words();
    }

    private static List<String> printTop20Words() {
        List<Map.Entry<String, WordInfo>> wordList = new ArrayList<>(wordCount.entrySet());
        wordList.sort(Map.Entry.comparingByValue());
        int wordsToPrint = Math.min(20, wordList.size());

        List<String> result = new ArrayList<>();

        for (int i = 0; i < wordsToPrint; i++)
            result.add("Word: " + wordList.get(i).getKey() + wordList.get(i).getValue());

        return result;
    }

    private static void processCandidateFiles(String directoryPath) {
        File directory = new File(directoryPath);

        if (directory.isDirectory() && directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Thread[] threads = new Thread[files.length];
                for (int i = 0; i < files.length; i++) {
                    File file = files[i];
                    if (file.isFile()) {
                        MyThread myThread = new MyThread(wordCount, file.getPath(), myLock);
                        Thread thread = new Thread(myThread);
                        thread.start();
                        threads[i] = thread;
                    }
                }

                for (Thread thread : threads) {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } else throw new RuntimeException();
    }

}