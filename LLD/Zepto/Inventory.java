import java.util.Map;
import java.util.HashMap;
class Inventory {
    Map<Product, InventoryItem> stock = new HashMap<>();

    void addProduct(Product product, int quantity) {
        stock.put(product, new InventoryItem(product, quantity));
    }

    boolean isAvailable(Product product, int quantity) {
        return stock.get(product).quantity >= quantity;
    }

    boolean reserve(Product product, int quantity) {
        return stock.get(product).reserve(quantity);
    }
    void release(Product product, int quantity) {
        stock.get(product).release(quantity);
    }
}