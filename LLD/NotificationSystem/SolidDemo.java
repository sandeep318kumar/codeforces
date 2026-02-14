class SolidDemo {
    public static void main(String[] args) {
        User user = new User("sandeep@gmail.com");
        UserRepository repo = new UserRepository();

        repo.save(user);

        MessageService email = new EmailService();
        NotificationManager manager = new NotificationManager(email);
        manager.notifyUser("Welcome to SOLID principles");

        MessageService sms = new SMSService();
        // NotificationManager smsManager = new NotificationManager(sms);
        // smsManager.notifyUser("Verification code: 1234");
        manager = new NotificationManager(sms);
        manager.notifyUser("Verification call");
    }
}