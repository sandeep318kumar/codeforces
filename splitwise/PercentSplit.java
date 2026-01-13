class PercentSplit extends Split {
    double percent;
    PercentSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }

    @Override
    public void calculeAmount(double totalAmount, int totalUsers) {
        this.amount = totalAmount * (percent / 100);
    }
}