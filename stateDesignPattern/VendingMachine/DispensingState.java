class DispensingState implements MachineState {
    public void action(Machine machine) {
        System.out.println("Dispensing " + machine.selectedProduct.name);

        machine.setState(new CatalogueState());
    }
}