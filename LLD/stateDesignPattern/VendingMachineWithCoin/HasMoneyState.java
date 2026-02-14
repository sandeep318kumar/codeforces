import java.util.List;
import java.util.ArrayList;
class HashMoneyState extends VendingMachineState {
    HashMoneyState() {
        System.out.println("Vending machine is in has money state;");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin){
        machine.coins.add(coin);
    }

    @Override
    public void clickonSelectProduct(VendingMachine machine) {
        machine.setState(new SelectionState());
    }

    @Override
    public double cancel(VendingMachine machine) {
        double coinValue = 0;
        for(Coin c: machine.coins) {
            coinValue += c.value;
        }
        System.out.println("Refunding " + coinValue + " to user");
        machine.setState(new IdleState(machine));
        return coinValue;
    }
}