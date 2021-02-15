package javaTdd.chap03_tdd;

/**
 * The Question class will hold the information about the question that has been posted by the user.
 */
public class Question {
    private int id;
    private int userId;
    private String title;
    private String message;
    private int votes;
    private User user;
    private static final int USER_RATINGS_PER_VOTE = 2;


    public Question() {
        this.user = new User();
    }


    /*
    Biz methods
     */
    public void vote() {
        votes++;
        this.user.increaseRating(USER_RATINGS_PER_VOTE);
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
}
