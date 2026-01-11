import java.util.ArrayList;
class IdleState extends VendingMachineState {

    IdleState() {
        System.out.println("Vending machine is in Idle State");
    }

    IdleState(VendingMachine machine) {
        System.out.println("Vending machine is in Idle State");
        machine.coins = new ArrayList<>();
        displayProducts(machine);
    }

    @Override
    public void addProduct(VendingMachine machine, Product prod) {
        machine.products.add(prod);
    }

    @Override
    public void pressInsertCoinButton(VendingMachine machine) {
        machine.setState(new HashMoneyState());
    }

    @Override
    public void displayProducts(VendingMachine machine) {
        System.out.println("Products available");
        for(Product p: machine.products) {
            System.out.println(p.name + ": " + p.price);
        }
    }
}