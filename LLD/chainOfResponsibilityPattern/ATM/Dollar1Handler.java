class Dollar1Handler extends DispenseChain {
    public void dispense(int amount ) {
        int count = amount;
        System.out.println("Dispensing " + count + " $1 bills");
    }
}