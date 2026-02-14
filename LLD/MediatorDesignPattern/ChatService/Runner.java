class Runner {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatRoom();

        User u1 = new ChatUser(mediator, "Phil");
        User u2 = new ChatUser(mediator, "Doku");
        User u3 = new ChatUser(mediator, "Khusanov");
        User u4 = new ChatUser(mediator, "Donnaruma");

        mediator.addUser(u1);
        mediator.addUser(u2);
        mediator.addUser(u3);
        mediator.addUser(u4);

        u1.send("Hello bois");
    }
}