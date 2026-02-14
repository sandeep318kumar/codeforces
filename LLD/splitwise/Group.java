import java.util.List;
import java.util.ArrayList;

class Group {
    public String groupId;
    public String name;
    List<User> members = new ArrayList<>();
    List<Expense> expenseHistory = new ArrayList<>();

    Group(String groupId, String name) {
        this.groupId = groupId;
        this.name = name;
    }

    public void addMember(User u) {
        members.add(u);
    }

    public void addExpense(Expense expense) {
        expenseHistory.add(expense);
    }

    public void showGroupHistory() {
        System.out.println("Expense history for group: " + name);
        for(Expense e: expenseHistory) {
            System.out.println("- " + e.expenseName + " : " + e.amount);
        }
    }
}