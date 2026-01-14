import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.math.BigDecimal;
import java.math.RoundingMode;

class Splitwise {
    private Map<User, List<BalanceEntry>> balances = new HashMap<>();

    static double round2(double value) {
        return BigDecimal.valueOf(value)
            .setScale(2, RoundingMode.HALF_UP)
            .doubleValue();
    }

    public void addUser(User u) {
        balances.putIfAbsent(u, new ArrayList<>());
    }

    public void addExpense(Expense ex) {
        int count = ex.splits.size();

        for(Split split: ex.splits) {
            split.calculeAmount(ex.amount, count);
        }

        // for this user, add other users.
        // for users involved, add the paidBy.
        for(Split split: ex.splits) {
            User user = split.user;
            if(user.equals(ex.paidBy)) continue;

            // paidBy should receive money.
            balances.get(ex.paidBy).add(new BalanceEntry(user, round2(split.amount)));

            // other users should give money.
            balances.get(user).add(new BalanceEntry(ex.paidBy, round2(-split.amount)));
        }
        if(ex.group != null) {
            ex.group.addExpense(ex);
        }
        System.out.println("Expense: " + ex.expenseName + " amount: ₹" + ex.amount + " by user: " + ex.paidBy.name + " added to Splitwise" );
    }

    public double amountRemainingForUser(User u) {
        List<BalanceEntry> l = balances.get(u);
        double balance = 0;
        for(BalanceEntry entry : l) {
            balance = round2(balance + entry.amount);
        }
        System.out.println("User " + u.name + " net balance: ₹" + balance);
        return balance;
    }

    public void allTransactionsHistory(User u) {
        // first calculate all takes and minus with gives.
        List<BalanceEntry> l = balances.get(u);
        for(BalanceEntry entry : l) {
            if(entry.amount < 0) {
                System.out.println(u.name +" -> " + entry.user.name + " : ₹" + entry.amount);
            } else {
                System.out.println( u.name + " -> " + entry.user.name + " : +₹" + entry.amount);
            }
        }
    }

    public List<Settlement> settleUp(Map<User, Double> net) {
        List<User> debtors = new ArrayList<>();
        List<User> creditors = new ArrayList<>();

        for(User user: net.keySet()) {
            if(net.get(user) < 0) {
                debtors.add(user);
            } else if(net.get(user) > 0) {
                creditors.add(user);
            }
        }

        List<Settlement> result = new ArrayList<>();
        int i = 0, j = 0;
        while(i < debtors.size() && j < creditors.size()) {
            User d = debtors.get(i);
            User c = creditors.get(j);

            double pay = round2(Math.min(-net.get(d), net.get(c)));
            result.add(new Settlement(d, c, pay));
            net.put(d, net.get(d) + pay );
            net.put(c, net.get(c) - pay);

            if(net.get(d) == 0) i++;
            if(net.get(c) == 0) j++;
        }
        return result;
    }

    public List<Settlement> settleUpPQ(Map<User, Double> net) {
        PriorityQueue<UserBalance> creditors = new PriorityQueue<>((a, b) -> Double.compare(b.amount, a.amount));
        PriorityQueue<UserBalance> debtors = new PriorityQueue<>((a, b) -> Double.compare(b.amount, a.amount));

        for(Map.Entry<User, Double> entry: net.entrySet()) {
            User user = entry.getKey();
            double amount = entry.getValue();
            if(net.get(user) < 0) {
                debtors.add(new UserBalance(user, -amount));
            } else if(net.get(user) > 0) {
                creditors.add(new UserBalance(user, amount));
            }
        }

        List<Settlement> result = new ArrayList<>();
        while(!debtors.isEmpty() && !creditors.isEmpty()) {
            UserBalance d = debtors.poll();
            UserBalance c = creditors.poll();

            double pay = round2(Math.min(d.amount, c.amount));
            result.add(new Settlement(d.user, c.user, pay));
            d.amount = round2(d.amount - pay);
            c.amount = round2(c.amount - pay);

            // push back if amount remaining.
            if(d.amount > 0.01) debtors.add(d);
            if(c.amount > 0.01) creditors.add(c);
        }
        return result;
    }

    public List<Settlement> settleUpGlobal() {
        Map<User, Double> net = new HashMap<>();

        for(User user: balances.keySet()) {
            double sum = 0;
            for(BalanceEntry entry: balances.get(user)) {
                sum += entry.amount;
            }
            net.put(user, round2(sum));
        }
        return settleUpPQ(net);
    }

    public List<Settlement> settleUpGroup(Group group) {
        Map<User, Double> net = new HashMap<>();
        for(User u: group.members) {
            net.put(u, 0.0);
        }

        for(Expense ex: group.expenseHistory) {
            for(Split split: ex.splits) {
                if(!split.user.equals(ex.paidBy)) {
                    net.put(ex.paidBy, round2(net.get(ex.paidBy) + split.amount));
                    net.put(split.user, round2(net.get(split.user) - split.amount));
                }
            }
        }
         
        return settleUpPQ(net);
    }

    public Map<User, Double> getNetBalances() {
        Map<User, Double> net = new HashMap<>();
        for (User u : balances.keySet()) {
            double sum = 0;
            for (BalanceEntry b : balances.get(u)) sum += b.amount;
            net.put(u, round2(sum));
        }
        return net;
    }
}