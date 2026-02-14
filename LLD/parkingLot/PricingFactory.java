class PricingFactory {
    public static PricingStrategy get(PricingType type, boolean tax) {
        PricingStrategy base = switch (type ) {
            case HOURLY -> new HourlyPricing();
            case MINUTE -> new MinutePricing();
            case DEFAULT -> new DefaultPricing();
        };

        return tax ? new TaxDecorator(base) : base;
    }
}