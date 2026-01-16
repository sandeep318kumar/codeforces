class BasicAmountCalculator implements AmountCalculation {
    Cart cart;

    BasicAmountCalculator(Cart cart) {
        this.cart = cart;
    }

    @Override
    public double calculateAmount() {
        BigDecimal amount = BigDecimal.ZERO;
        for(CartItem item: cart.itemsInCart) {
            amount = amount.add(BigDecimal.valueOf(item.product.price ).multiply(BigDecimal.valueOf(item.quantity));
        }
        return amount;
    }
}