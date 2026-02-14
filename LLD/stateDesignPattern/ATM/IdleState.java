class IdleState extends ATMState {

    public IdleState() {
        System.out.println("ATM current state is IDLE STATE");
        System.out.println("Insert the card");
    }

    @Override
    public void insertCard(ATM atm, Card card) {
        atm.setCard(card);
        atm.setState(new HasCardState());
    }

    @Override
    public void addCashToAtm(ATM atm, int amount) {
        atm.dispenser.addCashToAtm(amount);
    }
}