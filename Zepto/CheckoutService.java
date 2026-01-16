import java.util.List;
import java.util.ArrayList;

class CheckoutService {
    Inventory inventory;
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    CheckoutService(Inventory inventory) {
        this.inventory = inventory;
    }

    Order checkout(User user, Cart cart) {
        // 1. validate inventory
        for(CartItem item: cart.itemsInCart) {
            if(item.quantity > inventory.stock.get(item.product).quantity) {
                throw new RuntimeException(item.product.name + " Out of stock items");
            }
        }

        // 2. create order
        List<OrderItem> orderItems = new ArrayList<>();
        for(CartItem item : cart.itemsInCart) {
            orderItems.add(new OrderItem(item.product, item.quantity));
        }
        Order order = new Order(user, orderItems);
        
        // 3. calculate amount
        AmountCalculation calculator = new AddDeliveryFee(new AddTaxes(new BasicAmountCalculator(cart)));
        double finalAmount = calculator.calculateAmount();
        order.status = OrderStatus.PAYMENT_PENDING;

        // 4. Payment
        Payment payment = new Payment();
        boolean isPaid = payment.pay((int) finalAmount);
        if(!isPaid) {
            order.status = OrderStatus.FAILED;
            throw new RuntimeException("Payment failed, kindly retry");
        }

        order.markPaid(finalAmount);
        // 5. update the inventory.
        for(CartItem item : cart.itemsInCart) {
            inventory.updateQuantity(item.product, item.quantity, false);
        }

        // 6. Generate invoice
        order.invoice = invoiceGenerator.generate(order);

        // 7. order confirmed.
        order.confirm();
        order.invoice.printInvoice();
        
        System.out.println("Order placed successfully!!");
        return order;
    }
}