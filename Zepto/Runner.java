class Runner {
    public static void main(String[] args) {
        User u = new User("Phil", "Marathahalli 560037");
        Product p1 = new Product("Nandini Milk", CategoryType.DAILY_ESSENTIALS, 28);
        Product p2 = new Product("Muscle Blaze Oats", CategoryType.GROCERIES, 560);
        Product p3 = new Product("Wooden knife", CategoryType.GROCERIES, 100);
        Product p4 = new Product("Washing powder", CategoryType.GROCERIES, 976);
        Product p5 = new Product("Fresh Guava", CategoryType.FRESH_PRODUCE, 90);

        Inventory inventory = new Inventory();
        inventory.addProduct(p1, 15);
        inventory.addProduct(p2, 5);
        inventory.addProduct(p3, 7);
        inventory.addProduct(p4, 8);
        inventory.addProduct(p5, 10);

        Platform platform = new Platform(inventory);
        platform.displayAllProducts();

        Cart cart = new Cart();
        cart.addProductToCart(p1, 2);
        cart.addProductToCart(p2, 2);

        CheckoutService checkout = new CheckoutService(inventory);
        Order order = checkout.checkout(u, cart);

        platform.displayAllProducts();
    }
}