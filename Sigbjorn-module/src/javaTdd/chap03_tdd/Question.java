package javaTdd.chap03_tdd;

/**
 * The Question class will hold the information about the question that has been posted by the user.
 */
public class Question {
    private int id;
    private int userId;
    private String title;
    private String message;
    private boolean closed;
    private int votes;
    private User user;
    private static final int USER_RATINGS_PER_VOTE = 2;

    public enum VoteType { UP, DOWN };


    public Question() {
        this.user = new User();
    }


    /*
    Biz methods
     */
    public void vote(VoteType voteType) {
        if (!this.isClosed()) {
            if (voteType == VoteType.UP)
                voteUp();
            else
                voteDown();
        }
        else {
            throw new QuestionException("The question is closed. No voting allowed.", this.id);
        }
    }


    private void voteUp() {
        votes++;
        this.user.changeRating(USER_RATINGS_PER_VOTE);
    }

    private void voteDown() {
        votes--;
        this.user.changeRating(-USER_RATINGS_PER_VOTE);
    }



    /*
    Getters and setters
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getVotes() {
        return votes;
    }

    public User getUser() {
        return user;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
