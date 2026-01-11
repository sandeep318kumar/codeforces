class Runner {
    public static void main(String[] args) {
        Account acc1 = new Account("252252252");
        Account acc2 = new Account("929742973");
        Account acc3 = new Account("338753393");

        Card c1 = new Card("1213133");
        Card c2 = new Card("2324243");
        Card c3 = new Card("3434343");

        User u1 = new User("Nico", c1, acc1);
        User u2 = new User("Rodri", c2, acc2);
        User u3 = new User("Phil", c3, acc3);


        CashDispenser dis = new CashDispenser(100000);
        BankService bank = new BankService();
        bank.addUser(u1);
        bank.addUser(u2);
        bank.addUser(u3);


        ATM atm = new ATM(dis, bank);
        atm.setUser(u1);

        ATMState state = atm.getState();
        state.addCashToAtm(atm, 5000);
        state.insertCard(atm, c1);

        state = atm.getState();
        state.verifyCard(atm, c1);

        state = atm.getState();
        state.changeCardPin(atm);
        
        state = atm.getState();
        state.setCardPin(atm, "7890");

        state = atm.getState();
        state.withdrawMoney(atm, 5000);

        state = atm.getState();
        state.enterCardPin(atm, "7890");
        state.withdrawMoney(atm, 5000);

        // update balance for user 1
        bank.updateBalance(u1, 10000, true);
        

        // new transaction for withdrawing
        atm.setUser(u1);
        state = atm.getState();
        System.out.println("Runner " + state );
        state.insertCard(atm, c1);

        state = atm.getState();
        state.verifyCard(atm, c1);

        state = atm.getState();
        state.withdrawMoney(atm, 5000);


        state = atm.getState();
        state.enterCardPin(atm, "7890");
        state.withdrawMoney(atm, 5000);


    }
}