package bill;
import reservation.Reservation;

public class DailyBillingStrategy implements BillingStrategy {
    public double calculateAmount(Reservation reservation) {
        return reservation.interval.getDays() * 1000;
    }
}