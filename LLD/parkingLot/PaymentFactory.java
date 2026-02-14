class PaymentFactory {
    public static PaymentStrategy get(PaymentType type) {
        return type == PaymentType.UPI ? new UPIPayment() : new CardPayment();
    }
}