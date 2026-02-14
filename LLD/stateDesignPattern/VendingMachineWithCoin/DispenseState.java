import java.util.List;
import java.util.ArrayList;

class DispenseState extends VendingMachineState {
    DispenseState(VendingMachine machine, String code) {
        System.out.println("Vending machine is in Dispense state");
        dispenseProduct(machine, code);
    }

    @Override
    public Product dispenseProduct(VendingMachine machine, String code) {
        Product pro = machine.products.get(0);
        for(Product p : machine.products) {
            if(p.code.equals(code)) {
                pro = p;
                break;
            }
        }
        System.out.println("Product has been dispensed: " + pro.name);
        machine.products.remove(pro);
        machine.setState(new IdleState(machine));
        return pro;
    }
    
}