import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class Runner {
    public static void main(String[] args) throws InterruptedException {

        User u = new User("Phil", "Marathahalli 560037");
        Product p1 = new Product("Nandini Milk", CategoryType.DAILY_ESSENTIALS, 28);
        Product p2 = new Product("Muscle Blaze Oats", CategoryType.GROCERIES, 560);
        Product p3 = new Product("Wooden knife", CategoryType.GROCERIES, 100);
        Product p4 = new Product("Washing powder", CategoryType.GROCERIES, 976);
        Product p5 = new Product("Fresh Guava", CategoryType.FRESH_PRODUCE, 90);

        ProductCatalogue catalogue = new ProductCatalogue();
        catalogue.addProduct(p1);
        catalogue.addProduct(p2);
        catalogue.addProduct(p3);

        Iterator<Product> iterator = catalogue.createIterator();

        while(iterator.hasNext()) {
            Product p = iterator.next();
            System.out.println(p.name + " : ₹" + p.price);
        }

        Inventory inventory = new Inventory();
        inventory.addProduct(p1, 15);
        inventory.addProduct(p2, 5);
        inventory.addProduct(p3, 7);
        inventory.addProduct(p4, 8);
        inventory.addProduct(p5, 10);

        Platform platform = new Platform(inventory);
        CheckoutService checkout = new CheckoutService(inventory);
        platform.displayInventoryWithQuantity();

        // Cart cart = new Cart();
        // cart.addProductToCart(p1, 2);
        // cart.addProductToCart(p2, 2);
        // Order order = checkout.checkout(u, cart);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Runnable userTask = () -> {
            Cart cart = new Cart();
            cart.addProductToCart(p2, 2);
            try {
                Order order = checkout.checkout(new User(Thread.currentThread().getName(), "Bangalore"), cart);
                System.out.println(Thread.currentThread().getName() + " order succcess");
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + " order Failed " + e);
            }
        };
        executor.submit(userTask);
        executor.submit(userTask);
        executor.submit(userTask);
        
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        platform.displayInventoryWithQuantity();
    }
}