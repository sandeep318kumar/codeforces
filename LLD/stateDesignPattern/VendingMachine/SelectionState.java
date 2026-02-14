class SelectionState implements MachineState {
    public void action(Machine machine ) {
        machine.selectedProduct = machine.products.get(0);

        System.out.println("You have selected:  " + machine.selectedProduct.name);

        machine.setState(new PaymentState());
    }
}