abstract class User {
    ChatMediator mediator;
    String name;
    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg, User sender);
}