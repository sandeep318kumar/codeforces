import java.util.List;
import java.util.ArrayList;

class Machine {
    List<Product> products;
    Product selectedProduct;
    MachineState state;
    public Machine() {
        this.products = new ArrayList<>();
        this.state = new CatalogueState();
    }

    public void setState(MachineState state) {
        this.state = state;
    }

    public void changeState() {
        state.action(this);
    }

    public void addProduct(Product prod) {
        products.add(prod);
    }

    public void removeProd(Product prod) {
        products.remove(prod);
    }
}