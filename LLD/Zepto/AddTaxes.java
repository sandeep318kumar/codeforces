class AddTaxes extends AmountCalculatorDecorator {

    AddTaxes(AmountCalculation basic) {
        super(basic);
    }

    @Override
    public double calculateAmount() {
        return basic.calculateAmount() * 1.18;
    }
}