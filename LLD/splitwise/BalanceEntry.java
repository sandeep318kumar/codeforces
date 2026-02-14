class BalanceEntry {
    public User user;
    public double amount; // + -> take, -ve -> give

    BalanceEntry(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }
}