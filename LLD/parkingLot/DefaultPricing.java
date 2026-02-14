import java.time.LocalDateTime;

class DefaultPricing implements PricingStrategy {
    @Override
    public double calculate(LocalDateTime entry, LocalDateTime exit, double basePrice) {
        return basePrice;
    }
}