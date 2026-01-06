package bill;
import reservation.Reservation;

public class HourlyBillingStrategy implements BillingStrategy {
    public double calculateAmount(Reservation reservation) {
        return reservation.interval.getDays() * 24 * 50;
    }
}