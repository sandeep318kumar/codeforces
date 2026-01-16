class InventoryItem {
    Product product;
    int quantity;
    InventoryItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    void decreaseQuantity(int quantity) {
        this.quantity -= quantity;
    }
}