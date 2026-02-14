class Settlement {
    public User from;
    public User to;
    public double amount;

    Settlement(User from, User to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
}