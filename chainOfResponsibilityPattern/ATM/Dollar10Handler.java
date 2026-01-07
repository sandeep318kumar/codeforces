class Dollar10Handler extends DispenseChain {
    public void dispense(int amount ) {
        if(amount >= 10) {
            int count = amount / 10;
            int rem = amount % 10;

            System.out.println("Dispensing " + count + " $10 bills");
            if(rem != 0) {
                this.nextChain.dispense(rem);
            }
        } else {
            this.nextChain.dispense(amount);
        }
    }
}