import java.util.List;
import java.util.ArrayList;

class ChatRoom implements ChatMediator {
    List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String msg, User sender) {
        for(User u: users) {
            if(u != sender) {
                u.receive(msg, sender);
            }
        }
    }
}