import java.time.LocalDateTime;

class HourlyPricing implements PricingStrategy {
    @Override
    public double calculate(LocalDateTime entry, LocalDateTime exit, double basePrice) {
        return Math.max(1, java.time.Duration.between(entry, exit).toHours()) * basePrice;
    }
}