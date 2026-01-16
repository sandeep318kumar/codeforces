import java.util.List;
import java.util.UUID;
class Order {
    String orderId;
    User user;
    List<OrderItem> items;
    double totalAmount;
    OrderStatus status;
    Invoice invoice;

    Order(User user, List<OrderItem> items) {
        this.orderId = UUID.randomUUID().toString();
        this.user = user;
        this.items = items;
        this.status = OrderStatus.CREATED;
    }

    void markPaid(double amount) {
        this.totalAmount = amount;
        this.status = OrderStatus.PAID;
    }

    void confirm() {
        this.status = OrderStatus.CONFIRMED;
    }
}