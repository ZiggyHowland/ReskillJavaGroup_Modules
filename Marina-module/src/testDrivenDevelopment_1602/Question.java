package testDrivenDevelopment_1602;

public class Question {

    private int questionId;
    private String title;
    private String message;
    private int votes;
    private User user;
    private boolean isOpen = true;

    private static final long RATING_INCREASE = 10;

    public Question(String title, String message, User user) {
        this.title = title;
        this.message = message;
        this.user = user;
    }

    public void vote(boolean likeQuestion) {
        if (likeQuestion && isOpen) {
            user.rating = user.rating + RATING_INCREASE;
            votes++;
        }
        // ANDY: You need an "else if" to ensure you don't do any of the rest of the logic if the first "if" statement is true.
        // This explains why you're getting an exception in your test - it's because the 2nd "if" statement fails so it then goes into the "else" part. 
        else if (!likeQuestion && isOpen) {
            // ANDY: Ditto
            user.rating = user.rating - 10;
            votes--;
        } else {
            // ANDY: Whoever calls vote() will have to catch it. 
            // Also note, QuestionException inherits from RuntimeException, which means it's not a "checked" exception, which means the compiler won't enforce that you catch it.
            throw new QuestionException("The question is closed and cannot be voted on.\n"); //Why do we not have to catch this exception
        }
    }

    public int getVotes() {
        return votes;
    }

    public User getUser() {
        return user;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
