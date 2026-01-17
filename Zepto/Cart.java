import java.util.List;
import java.util.ArrayList;

class Cart {
    List<CartItem> itemsInCart = new ArrayList<>();

    void addProductToCart(Product prod, int quantity) {
        itemsInCart.add(new CartItem(prod, quantity));
        System.out.println(prod.name + " :" + quantity + " added to cart");
    }

    void removeProductFromCart(Product prod) {
        itemsInCart.removeIf(i -> i.product.equals(prod));
    }
}