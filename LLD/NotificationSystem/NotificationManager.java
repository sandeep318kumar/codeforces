class NotificationManager {
    private final MessageService service;

    NotificationManager (MessageService service) {
        this.service = service;
    }

    public void notifyUser(String message) {
        service.sendMessage(message);
    }
}