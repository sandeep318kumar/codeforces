class WithdrawState extends ATMState {
    WithdrawState() {
        System.out.println("ATM current state is WITHDRAW STATE");
    }

    @Override
    public void withdrawMoney(ATM atm, int amount) {
        if(atm.bankService.getBalance(atm.user) >= amount) {
            atm.setState(new DispenseMoneyState());
            atm.getState().dispenseMoney(atm, amount);
        } else {
            System.out.println("Insufficient account balance!");
            atm.setState(new EjectCardState());
            atm.getState().ejectCard(atm);
        }
    }

    @Override
    public void enterCardPin(ATM atm, String pin) {
        if(validatesPin(atm, pin)) {
            System.out.println("Pin verified successfully");
        } else {
            System.out.println("Pin verification failed!!");
            atm.setState(new EjectCardState());
            atm.getState().ejectCard(atm);
        }
    }

    @Override
    public boolean validatesPin(ATM atm, String pin) {
        return atm.bankService.verifyPin(atm.user, pin);
    }
}