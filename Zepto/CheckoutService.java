class CheckoutService {
    Inventory inventory;

    CheckoutService(Inventory inventory) {
        this.inventory = inventory;
    }

    void checkout(Cart cart) {
        // 1. validate inventory
        for(CartItem item: cart.itemsInCart) {
            if(item.quantity > inventory.stock.get(item.product).quantity) {
                throw new RuntimeException(item.product.name + " Out of stock items");
            }
        }
        // 2. calculate amount
        AmountCalculation calculator = new AddDeliveryFee(new AddTaxes(new BasicAmountCalculator(cart)));
        double finalAmount = calculator.calculateAmount();

        // 3. Payment
        Payment payment = new Payment();
        boolean isPaid = payment.pay((int) finalAmount);

        // 4. update the inventory.
        if(isPaid) {
            // reduce the inventory.
            for(CartItem item : cart.itemsInCart) {
                inventory.updateQuantity(item.product, item.quantity, false);
            }
        // 5. order confirmed.
            System.out.println("Order placed successfully!!");
        } else {
            throw new RuntimeException("Payment failed, kindly retry");
        }
    }
}