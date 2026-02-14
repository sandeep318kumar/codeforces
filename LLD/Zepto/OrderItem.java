class OrderItem {
    Product product;
    int quantity;
    int priceAtPurchase;

    OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.priceAtPurchase = product.price;
    }

    int getTotal() {
        return priceAtPurchase * quantity;
    }
}