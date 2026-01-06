package bill;

import reservation.Reservation;
public class BillManager {
    public BillingStrategy strategy;

    public BillManager(BillingStrategy strategy) {
        this.strategy = strategy;
    }

    public Bill generateBill(Reservation reservation) {
        return new Bill(reservation, strategy.calculateAmount(reservation));
    }
}