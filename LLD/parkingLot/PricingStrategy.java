import java.time.LocalDateTime;

interface PricingStrategy {
    double calculate(LocalDateTime entry, LocalDateTime exit, double basePrice);
}