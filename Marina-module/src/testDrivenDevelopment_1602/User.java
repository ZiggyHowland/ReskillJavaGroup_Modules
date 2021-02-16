package testDrivenDevelopment_1602;

public class User {

    int userId;
    String name;
    String email;
    long rating = 0;

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getRating() {
        return rating;
    }
}
