class EjectCardState extends ATMState {
    EjectCardState() {
        System.out.println("ATM current state is EJECT CARD STATE");
    }

    public void ejectCard(ATM atm) {
        System.out.println("Card has been ejected");
        atm.setUser(null);
        atm.setCard(null);
        atm.setState(new IdleState());
    }
}