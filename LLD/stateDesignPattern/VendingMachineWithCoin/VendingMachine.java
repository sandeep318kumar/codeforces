import java.util.List;
import java.util.ArrayList;
class VendingMachine {
    public VendingMachineState state;
    public List<Product> products;

    public List<Coin> coins;

    VendingMachine() {
        products = new ArrayList<>();
        coins = new ArrayList<>();
        state = new IdleState();
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public VendingMachineState getState() {
        return state;
    }
}