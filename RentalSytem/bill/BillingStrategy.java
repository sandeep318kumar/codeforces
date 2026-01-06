package bill;
import reservation.Reservation;

public interface BillingStrategy {
    double calculateAmount(Reservation reservation);
}