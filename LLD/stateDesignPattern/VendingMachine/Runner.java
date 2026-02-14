class Runner {
    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.addProduct(new Product("Amul Paneer", 200.0));
        machine.addProduct(new Product("Nandini Milk", 35.0));
        machine.changeState();
        machine.changeState();
        machine.changeState();
        machine.changeState();

    }
}