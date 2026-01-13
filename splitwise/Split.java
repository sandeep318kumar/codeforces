abstract class Split {
    public User user;
    public double amount;

    Split(User user) {
        this.user = user;
    }

    abstract void calculeAmount(double totalAmount, int totalUsers);
}