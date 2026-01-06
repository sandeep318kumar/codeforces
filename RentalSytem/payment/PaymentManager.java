package payment;

public class PaymentManager {
    public PaymentStrategy strategy;

    public PaymentManager(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void makePayment(double amount) {
        strategy.pay(amount);
    }
}