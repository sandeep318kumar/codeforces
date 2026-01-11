class HasCardState extends ATMState {

    HasCardState() {
        System.out.println("ATM current state is HAS CARD STATE");
    }
    @Override
    public void verifyCard(ATM atm, Card card) {
        if(atm.bankService.verifyCard(atm.user, card)) {
            System.out.println("Card verfication successful!");
            atm.setState(new TransactionalSelectionState());
        } else {
            System.out.println("Card verification failed!!");
            atm.setState(new EjectCardState());
            atm.getState().ejectCard(atm);
        }
    }
}