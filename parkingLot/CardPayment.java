class CardPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Payment has been done for " + amount + " through Card");
        return true;
    }
}