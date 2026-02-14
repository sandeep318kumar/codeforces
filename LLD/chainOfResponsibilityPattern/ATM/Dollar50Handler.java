class Dollar50Handler extends DispenseChain {
    public void dispense(int amount ) {
        if(amount >= 50) {
            int count = amount / 50;
            int rem = amount % 50;

            System.out.println("Dispensing " + count + " $50 bills");
            if(rem != 0) {
                this.nextChain.dispense(rem);
            }
        } else {
            this.nextChain.dispense(amount);
        }
    }
}