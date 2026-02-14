abstract class AmountCalculatorDecorator implements AmountCalculation {
    AmountCalculation basic;

    AmountCalculatorDecorator(AmountCalculation basic) {
        this.basic = basic;
    }

    @Override
    public double calculateAmount() {
        return basic.calculateAmount();
    }
}