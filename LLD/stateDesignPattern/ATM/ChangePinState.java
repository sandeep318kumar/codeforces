class ChangePinState extends ATMState {
    ChangePinState() {
        System.out.println("ATM current state is CHANGE PIN STATE");
    }

    @Override
    public void setCardPin(ATM atm, String pin) {
        if(OtpVerifation(atm, pin)) {
            atm.bankService.setPin(atm.user, pin);
            atm.setState(new TransactionalSelectionState());
        } else {
            System.out.println("OTP Verificaton failed!!");
            atm.setState(new EjectCardState());
            atm.getState().ejectCard(atm);
        }
    }

    public boolean OtpVerifation(ATM atm, String pin) {
        System.out.println("OTP verified successfully.");
        return true;
    }
}