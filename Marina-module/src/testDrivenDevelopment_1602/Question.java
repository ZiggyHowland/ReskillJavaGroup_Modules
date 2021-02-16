package testDrivenDevelopment_1602;



public class Question {

    int questionId;
    String title;
    String message;
    int votes;
    User user;
    boolean isOpen = true;

    public Question(String title, String message, User user) {
        this.title = title;
        this.message = message;
        this.user = user;
    }

    public void vote(boolean likeQuestion) {
        if (likeQuestion && isOpen) {
            user.rating = user.rating + 10;
            votes++;
        }
        if (!likeQuestion && isOpen) {
            user.rating = user.rating - 10;
            votes--;
        } else {
            throw new QuestionException("The question is closed and cannot be voted on.\n"); //Why do we not have to catch this exception
        }
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
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
