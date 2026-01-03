import java.time.LocalDateTime;

class TaxDecorator extends PricingDecorator {
    TaxDecorator(PricingStrategy pricingStrategy) {
        super(pricingStrategy);
    }
    public double calculate(LocalDateTime entry, LocalDateTime exit, double base) {
        return pricingStrategy.calculate(entry, exit, base) * 1.18;
    }
}