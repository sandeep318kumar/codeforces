class Dollar5Handler extends DispenseChain {
    public void dispense(int amount ) {
        if(amount >= 5) {
            int count = amount / 5;
            int rem = amount % 5;

            System.out.println("Dispensing " + count + " $5 bills");
            if(rem != 0) {
                this.nextChain.dispense(rem);
            }
        } else {
            this.nextChain.dispense(amount);
        }
    }
}