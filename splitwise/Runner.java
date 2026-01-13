import java.util.List;
import java.util.Arrays;
class Runner {
    public static void main(String[] args) {
        User a = new User("Nico");
        User b = new User("Rodri");
        User c = new User("Phil");

        Splitwise sw = new Splitwise();
        sw.addUser(a);
        sw.addUser(b);
        sw.addUser(c);

        Group trip = new Group("G1", "Goa Trip");
        trip.addMember(a);
        trip.addMember(b);
        trip.addMember(c);

        List<Split> s1 = Arrays.asList(new EqualSplit(a), new EqualSplit(b), new EqualSplit(c));
        Expense hotel = new Expense("Hotel Dream Home", 3000, s1, a, trip);
        Expense surfing = new Expense("Surfing", 4000, List.of(new EqualSplit(a), new EqualSplit(b)), b, trip);
        sw.addExpense(hotel);
        sw.addExpense(surfing);


        Expense e1 = new Expense("Lunch", 300, List.of(new EqualSplit(a), new EqualSplit(b), new EqualSplit(c)), a, null);
        Expense e2 = new Expense("Dinner", 400, List.of(new ExactSplit(a, 100), new ExactSplit(b, 150), new ExactSplit(c, 150)), b, null);
        Expense e3 = new Expense("Football", 600, List.of(new PercentSplit(a, 20), new PercentSplit(b, 30 ), new PercentSplit(c, 50)), c, null);


        sw.addExpense(e1);
        sw.addExpense(e2);
        sw.addExpense(e3);

        // group expense history
        trip.showGroupHistory();

        // user balances:
        sw.amountRemainingForUser(a);
        sw.amountRemainingForUser(b);
        sw.amountRemainingForUser(c);
        

        // sw.allTransactionsHistory(a);
        // sw.allTransactionsHistory(b);
        // sw.allTransactionsHistory(c);

        // Group settle ups.
        System.out.println("Group settle-up: ");
        List<Settlement> groupSettle = sw.settleUpGroup(trip);
        printSettlements(groupSettle);


        // global settle ups.
        System.out.println("Global settle ups");
        List<Settlement> globalSettle = sw.settleUpGlobal();
        printSettlements(globalSettle);
    }
    private static void printSettlements(List<Settlement> settlements) {
        for(Settlement s: settlements) {
            System.out.println(s.from.name + " pays " + s.to.name + " ₹" + s.amount);
        }
    }
}