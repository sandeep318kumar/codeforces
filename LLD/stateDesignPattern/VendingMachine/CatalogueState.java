class CatalogueState implements MachineState {
    public void action(Machine machine) {
        // displaying all products.
        System.out.println("Displaying all products here!!");
        for(Product p: machine.products) {
            System.out.println("Product name is: " + p.name + " price is: " + p.price);
        }

        machine.setState(new SelectionState());
    }
}