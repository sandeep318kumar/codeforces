class BasicAmountCalculator implements AmountCalculation {
    Cart cart;

    BasicAmountCalculator(Cart cart) {
        this.cart = cart;
    }

    @Override
    public double calculateAmount() {
        int amount = 0;
        for(CartItem item: cart.itemsInCart) {
            amount += (item.product.price ) * item.quantity;
        }
        return amount;
    }
}