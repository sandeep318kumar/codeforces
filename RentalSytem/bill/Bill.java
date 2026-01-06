package bill;

import reservation.Reservation;

public class Bill {
    private Reservation reservation;
    public double amount;

    Bill(Reservation reservation, double amount) {
        this.reservation = reservation;
        this.amount = amount;
    }
}