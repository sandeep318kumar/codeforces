class DispenseMoneyState extends ATMState {
    DispenseMoneyState() {
        System.out.println("ATM current state is DISPENSE MONEY STATE");
    }

    @Override
    public void dispenseMoney(ATM atm, int amount) {
        atm.dispenser.dispenseCash(amount);
        atm.setState(new EjectCardState());
        atm.getState().ejectCard(atm);
    }
}