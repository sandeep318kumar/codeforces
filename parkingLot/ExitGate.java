import java.time.LocalDateTime;

class ExitGate {
    private PricingStrategy pricingStrategy;

    ExitGate(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculateCost(Ticket ticket) {
        return pricingStrategy.calculate(ticket.getEntryTime(), LocalDateTime.now(), ticket.getSpot().getBasePrice());
    }

    public void processExit(Ticket ticket, PaymentStrategy payment) {
        double amount = calculateCost(ticket);
        if(payment.pay(amount)) {
            ticket.getSpot().unPark();
        }
    }
}