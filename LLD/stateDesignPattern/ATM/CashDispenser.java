class CashDispenser {
    public int amountInAtm;
    CashDispenser(int amountInAtm) {
        this.amountInAtm = amountInAtm;
    }

    public void dispenseCash(int amount) {
        this.amountInAtm -= amount;
        System.out.println("Dispensed amount: " + amount + " to user.");
    }

    public void addCashToAtm(int amount) {
        this.amountInAtm += amount;
    }
}