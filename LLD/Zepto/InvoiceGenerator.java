class InvoiceGenerator {
    Invoice generate(Order order) {
        double base = order.totalAmount / 1.18 - 50;
        double tax = base * 0.18;
        double deliveryFee = 50;
        
        return new Invoice(order.orderId, order.totalAmount, tax, deliveryFee);
    }
}