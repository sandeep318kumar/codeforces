abstract class ATMState {
    protected void invalidOperation(String op) {
        throw new IllegalStateException(op + " not allowed in current state");
    }

    public void addCashToAtm(ATM atm, int amount) {
        invalidOperation("add cash to ATM");
    }

    public void insertCard(ATM atm, Card card) {
        invalidOperation("Insert card");
    }

    public void verifyCard(ATM atm, Card card) {
        invalidOperation("verify card");
    }

    public void chooseAccount(ATM atm) {
        invalidOperation("choose account");
    }

    public void withdrawMoney(ATM atm, int amount) {
        invalidOperation("withdraw money");
    }

    public void changeCardPin(ATM atm) {
        invalidOperation("change car pin");
    }

    public void enterCardPin(ATM atm, String pin) {
        invalidOperation("enter card pin");
    }

    public boolean validatesPin(ATM atm, String pin) {
        invalidOperation("validates pin");
        return false;
    }

    public void dispenseMoney(ATM atm, int amount) {
        invalidOperation("dispense money");
    }

    public void ejectCard(ATM atm) {
        invalidOperation("eject card");
    }

    public void setCardPin(ATM atm, String pin) {
        invalidOperation("set card pin");
    }
}