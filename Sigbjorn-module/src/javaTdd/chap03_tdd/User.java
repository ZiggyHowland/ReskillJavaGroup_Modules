package javaTdd.chap03_tdd;

public class User {
    private int id;
    private String name;
    private String emailAddress;
    private int rating;





    /*
    Biz methods
     */
    public void changeRating(int change) {
        this.rating += change;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getRating() {
        return rating;
    }

}
