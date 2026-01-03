abstract class PricingDecorator implements PricingStrategy {
    protected PricingStrategy pricingStrategy;
    PricingDecorator(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }
}