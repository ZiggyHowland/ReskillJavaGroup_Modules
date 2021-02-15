package javaTdd.chap03_tdd;

public class QuestionException extends RuntimeException {
    private int questionId;

    public QuestionException(String message, int questionId) {
        super(message);
        this.questionId = questionId;
    }


}
