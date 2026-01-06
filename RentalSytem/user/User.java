package user;

public class User {
    private String userName;
    private String userId;

    public User(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public String getName() {
        return this.userName;
    }

    public String getUserId() {
        return this.userId;
    }
}