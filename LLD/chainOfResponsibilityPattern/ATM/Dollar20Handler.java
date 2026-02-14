class Dollar20Handler extends DispenseChain {
    public void dispense(int amount ) {
        if(amount >= 20) {
            int count = amount / 20;
            int rem = amount % 20;

            System.out.println("Dispensing " + count + " $20 bills");
            if(rem != 0) {
                this.nextChain.dispense(rem);
            }
        } else {
            this.nextChain.dispense(amount);
        }
    }
}