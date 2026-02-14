class ATM {
    public ATMState state;
    public Card currentCard;
    public Account selectedAccount;
    public CashDispenser dispenser;
    public BankService bankService;
    public User user;

    ATM(CashDispenser dis, BankService bank) {
        this.state = new IdleState();
        this.dispenser = dis;
        this.bankService = bank;
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public ATMState getState() {
        return state;
    }

    public void setUser(User u1) {
        this.user = u1;
        this.selectedAccount = (u1 != null) ? u1.account : null;
    }

    public void setCard(Card card) {
        this.currentCard = card;
    }
}