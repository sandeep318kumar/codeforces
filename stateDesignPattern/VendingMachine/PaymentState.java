class PaymentState implements MachineState {
    public void action(Machine machine ) {
        System.out.println("Kindly make the payment for " + machine.selectedProduct.name + " of amount: " + machine.selectedProduct.price);
        // sleep(2000);
        System.out.println("Payment successful for amount: " + machine.selectedProduct.price);

        machine.setState(new DispensingState());
    }
}