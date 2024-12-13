package lapr4.jobs4u.lprog.interviewModels;

public class Answer {
    String answerText;
    Integer mark;

    public Answer(String answerText, Integer mark) {
        this.answerText = answerText;
        this.mark = mark;
    }

    public Answer(Integer mark) {
        this.mark = mark;
    }

    public Answer(String answerText) {
        this.answerText = answerText;
    }

    @Override
    public String toString() {
        return "Answer: " + answerText + ", Mark: " + mark;
    }

}
