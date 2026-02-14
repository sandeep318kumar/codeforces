class TransactionalSelectionState extends ATMState {
    TransactionalSelectionState() {
        System.out.println("ATM current state is TRANSACTIONAL SELECTION STATE");
    }

    @Override
    public void withdrawMoney(ATM atm, int amount) {
        atm.setState(new WithdrawState());
    }

    @Override
    public void changeCardPin(ATM atm) {
        atm.setState(new ChangePinState());
    }
}