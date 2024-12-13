package lapr4.jobs4u.scomp.US4000;

import java.util.HashSet;
import java.util.Set;

public class WordInfo implements Comparable<WordInfo> {
    private Integer count;
    private final Set<String> fileNames;

    public WordInfo() {
        this.count = 0;
        this.fileNames = new HashSet<>();
    }

    public void incrementWordCount() {
        this.count++;
    }

    public void addFileName(String file) {
        this.fileNames.add(file);
    }

    @Override
    public String toString() {
        return " Found this many times: " + count + " ,In these files: " + fileNames;
    }

    @Override
    public int compareTo(WordInfo other) {
        return other.count.compareTo(this.count);
    }
}
