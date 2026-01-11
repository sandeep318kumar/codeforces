import java.util.List;
import java.util.ArrayList;
class SelectionState extends VendingMachineState {
    SelectionState() {
        System.out.println("Vending machine in Selection state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, String code) {
        double productPrice = -1;
        for(Product p : machine.products) {
            if(p.code.equals(code)) {
                productPrice = p.price;
                break;
            }
        }
        if(productPrice == -1) {
            System.out.println("Invalid Code!");
            return;
        }
        double coinValue = 0;
        for(Coin c: machine.coins) {
            coinValue += c.value;
        }

        if(productPrice > coinValue) {
            // refund full amount.
            System.out.println("Product price is more than the coin Value, issuing full refund.");
            cancel(machine);
        } else {
            if(productPrice < coinValue) {
                returnChange(coinValue - productPrice);
            }

            machine.setState(new DispenseState(machine, code));
        }
    }

    @Override
    public double cancel(VendingMachine machine) {
        double coinValue = 0;
        for(Coin c: machine.coins) {
            coinValue += c.value;
        }
        System.out.println("Refunding amount: " + coinValue + " to user");
        machine.setState(new IdleState(machine));
        return coinValue;
    }

    @Override
    public double returnChange(double amount) {
        System.out.println("Here is your change: " + amount);
        return amount;
    }

}