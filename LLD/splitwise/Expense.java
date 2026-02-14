import java.util.List;

class Expense {
    public String expenseName;
    public double amount;
    public List<Split> splits;
    public User paidBy;
    public Group group;

    Expense(String expenseName, double amount, List<Split> splits, User paidBy, Group group ) {
        this.expenseName = expenseName;
        this.amount = amount;
        this.splits = splits;
        this.paidBy = paidBy;
        this.group = group;
    }
}