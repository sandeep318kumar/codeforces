package payment;

public class CashPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Payment successfull via Cash, amount: " + amount);
    }
}