class EqualSplit extends Split {
    EqualSplit(User user) {
        super(user);
    }

    @Override
    public void calculeAmount(double totalAmount, int totalUsers) {
        this.amount = totalAmount / totalUsers;
    }
}