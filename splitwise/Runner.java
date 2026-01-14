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


        Group soloTrip = new Group("G2", "Solo Trip");
        soloTrip.addMember(a);

        Expense soloHotel = new Expense(
            "Solo Hotel",
            2000,
            List.of(new EqualSplit(a)),
            a,
            soloTrip
        );
        sw.addExpense(soloHotel);

        System.out.println("\nSolo Trip settle-up:");
        printSettlements(sw.settleUpGroup(soloTrip));


        Expense sponsorDinner = new Expense(
            "Sponsored Dinner",
            900,
            List.of(new EqualSplit(a), new EqualSplit(b), new EqualSplit(c)),
            a,   // a paid
            null
        );
        sw.addExpense(sponsorDinner);
        Expense scuba = new Expense(
            "Scuba Diving",
            3000,
            List.of(new EqualSplit(a), new EqualSplit(b)),
            a,
            trip
        );
        sw.addExpense(scuba);

        System.out.println("\nAfter Scuba:");
        trip.showGroupHistory();

        System.out.println("\nGroup settle-up after scuba:");
        printSettlements(sw.settleUpGroup(trip));

        User d = new User("Messi");
        sw.addUser(d);

        System.out.println("\nUser with no expenses:");
        sw.amountRemainingForUser(d);

        System.out.println("\nGlobal settle-up (should NOT include Messi):");
        printSettlements(sw.settleUpGlobal());

        Expense party = new Expense(
            "Party",
            1000,
            List.of(
                new ExactSplit(a, 400),
                new ExactSplit(b, 300),
                new ExactSplit(c, 300)
            ),
            c,
            null
        );
        sw.addExpense(party);

        System.out.println("\nBalances after party:");
        sw.amountRemainingForUser(a);
        sw.amountRemainingForUser(b);
        sw.amountRemainingForUser(c);

        System.out.println("\nGlobal settle-up after party:");
        printSettlements(sw.settleUpGlobal());

        System.out.println("\nGroup settle-up (Trip only):");
        printSettlements(sw.settleUpGroup(trip));

        System.out.println("\nGlobal settle-up (ALL expenses):");
        printSettlements(sw.settleUpGlobal());

        System.out.println("\nRunning settle-up twice:");
        printSettlements(sw.settleUpGlobal());
        printSettlements(sw.settleUpGlobal());


        Expense uneven = new Expense(
            "Uneven Expense",
            999,
            List.of(
                new PercentSplit(a, 33.33),
                new PercentSplit(b, 33.33),
                new PercentSplit(c, 33.34)
            ),
            a,
            null
        );
        sw.addExpense(uneven);

        System.out.println("\nAfter uneven split:");
        printSettlements(sw.settleUpGlobal());

        User e = new User("Iniesta");
        sw.addUser(e);

        Group footballGroup = new Group("G3", "Football Buddies");
        footballGroup.addMember(e);
        footballGroup.addMember(a);

        Expense turf = new Expense(
            "Turf Booking",
            1200,
            List.of(new EqualSplit(a), new EqualSplit(e)),
            e,
            footballGroup
        );
        sw.addExpense(turf);

        System.out.println("\nFootball group settle-up:");
        printSettlements(sw.settleUpGroup(footballGroup));

        System.out.println("\nFinal balances:");
        sw.amountRemainingForUser(a);
        sw.amountRemainingForUser(b);
        sw.amountRemainingForUser(c);
        sw.amountRemainingForUser(d);

        System.out.println("\n===== NORMAL vs PQ SETTLE TEST =====");

        User A = new User("A");
        User B = new User("B");
        User C = new User("C");
        User D = new User("D");
        User E = new User("E");

        Splitwise swTest = new Splitwise();
        swTest.addUser(A);
        swTest.addUser(B);
        swTest.addUser(C);
        swTest.addUser(D);
        swTest.addUser(E);

        // A paid 150 for everyone
        swTest.addExpense(new Expense(
            "Big Dinner",
            150,
            List.of(
                new ExactSplit(A, 0),
                new ExactSplit(B, 0),
                new ExactSplit(C, 30),
                new ExactSplit(D, 30),
                new ExactSplit(E, 90)
            ),
            A,
            null
        ));

        // B paid 50 for C and D
        swTest.addExpense(new Expense(
            "Snacks",
            50,
            List.of(
                new ExactSplit(B, 0),
                new ExactSplit(C, 0),
                new ExactSplit(D, 0),
                new ExactSplit(E, 0)
            ),
            B,
            null
        ));

        System.out.println("\n--- Normal settle ---");
        List<Settlement> normal = swTest.settleUp(swTest.getNetBalances());
        printSettlements(normal);
        System.out.println("Transactions = " + normal.size());

        System.out.println("\n--- PQ settle ---");
        List<Settlement> pq = swTest.settleUpPQ(swTest.getNetBalances());
        printSettlements(pq);
        System.out.println("Transactions = " + pq.size());

    }
    private static void printSettlements(List<Settlement> settlements) {
        for(Settlement s: settlements) {
            System.out.println("- " + s.from.name + " pays " + s.to.name + " ₹" + s.amount);
        }
    }
}