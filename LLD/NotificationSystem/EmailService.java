class EmailService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Sending email " + message);
    }
}