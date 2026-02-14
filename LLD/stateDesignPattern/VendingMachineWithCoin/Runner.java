class Runner {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        VendingMachineState state = machine.getState();
        state.addProduct(machine, new Product("Coke", "12", 200.0));
        state.addProduct(machine, new Product("Pepsi", "13", 100.0));
        state.addProduct(machine, new Product("Diet", "14", 150.0));
        state.addProduct(machine, new Product("Dew", "15", 250.0));
        state.displayProducts(machine);

        state.pressInsertCoinButton(machine);

        state = machine.getState();
        state.insertCoin(machine, new Coin(100));
        state.insertCoin(machine, new Coin(50));
        state.clickonSelectProduct(machine);

        state = machine.getState();
        state.chooseProduct(machine, "14");

        state = machine.getState();
        state.displayProducts(machine);
    }
}