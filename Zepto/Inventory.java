import java.util.Map;
import java.util.HashMap;
class Inventory {
    Map<Product, InventoryItem> stock = new HashMap<>();

    void addProduct(Product prod, int quantity) {
        stock.put(prod, new InventoryItem(prod, quantity));
    }

    boolean isAvailable(Product prod, int quantity) {
        return stock.get(prod).quantity >= quantity;
    }

    void updateQuantity(Product prod, int quantity, boolean add) {
        if(add) {
            stock.get(prod).increaseQuantity(quantity);
        } else {
            stock.get(prod).decreaseQuantity(quantity);
        }
    }
}