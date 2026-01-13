class ExactSplit extends Split {
    ExactSplit(User user, int amount) {
        super(user);
        this.amount = amount;
    }

    @Override
    public void calculeAmount(double totalAmount, int totalUsers) {
        // already known.
    }
}