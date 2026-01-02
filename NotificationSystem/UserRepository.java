class UserRepository {
    void save(User user) {
        System.out.println("saving user " + user.email + " to database");
    }
}