import java.util.Map;
import java.util.HashMap;
class BankService {
    Map<User, String> allUsers;

    BankService() {
        this.allUsers = new HashMap<>();
    }

    public void addUser(User user) {
        allUsers.put(user, "NA");
    }

    public void setPin(User user, String pin) {
        allUsers.put(user, pin);
    }

    public boolean verifyPin(User user, String pin) {
        return allUsers.get(user).equals(pin);
    }

    public boolean verifyCard(User user, Card card) {
        return user.card.cardNo.equals(card.cardNo);
    }

    public void updateBalance(User user, int amount, boolean credit) {
        String pin = allUsers.get(user);
        allUsers.remove(user);
        user.account.balance = (credit) ? user.account.balance + amount : user.account.balance - amount;
        System.out.println("Balance has been updated for user: " + user.name);
        allUsers.put(user, pin);
    }

    public int getBalance(User user) {
        return user.account.balance;
    }
}