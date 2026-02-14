package payment;
public class UpiPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Payment successfull via UPI, amount: " + amount);
    }
}