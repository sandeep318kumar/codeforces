class AddDeliveryFee extends AmountCalculatorDecorator {

    AddDeliveryFee(AmountCalculation basic) {
        super(basic);
    }

    @Override
    public double calculateAmount() {
        return basic.calculateAmount() + 50.0;
    }
}