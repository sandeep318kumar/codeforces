import java.time.LocalDateTime;
import java.util.UUID;

class Invoice {
    String invoiceId;
    String orderId;
    double amount;
    double tax;
    double deliveryFee;
    LocalDateTime generatedAt;

    Invoice(String orderId, double amount, double tax, double deliveryFee) {
        this.invoiceId = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.amount = amount;
        this.tax = tax;
        this.deliveryFee = deliveryFee;
        this.generatedAt = LocalDateTime.now();
    }

    void printInvoice() {
        System.out.println("=====INVOICE======");
        System.out.println("Invoice id: " + invoiceId);
        System.out.println("Base amount: " + (amount - tax - deliveryFee));
        System.out.println("tax: " + tax);
        System.out.println("delivery fee: " + deliveryFee);
        System.out.println("Total amount: " + amount);
        System.out.println("generated at: " + generatedAt);
        System.out.println("=====================");
    }
}