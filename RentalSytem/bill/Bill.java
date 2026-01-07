package bill;

import reservation.Reservation;

public class Bill {
    private Reservation reservation;
    public double amount;

    Bill(Reservation reservation, double amount) {
        this.reservation = reservation;
        this.amount = amount;

        System.out.println("Bill generated for reservation " + reservation.getReservationId() + " for amount: " + amount);
    }
}