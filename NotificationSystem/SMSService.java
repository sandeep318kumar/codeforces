class SMSService implements MessageService {
    public void sendMessage (String message) {
        System.out.println("sending sms " + message);
    }
}