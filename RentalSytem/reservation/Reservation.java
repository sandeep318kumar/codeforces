package reservation;

import user.User;
import vehicle.Vehicle;
import enums.ReservationStatus;
import enums.ReservationType;
import util.DateInterval;

public class Reservation {
    public User user;
    public Vehicle vehicle;
    private String reservationId;
    public DateInterval interval;
    public ReservationStatus status;
    public ReservationType type;

    public Reservation(User user, Vehicle vehicle, String reservationId, DateInterval interval, ReservationType type) {
        this.user = user;
        this.vehicle = vehicle;
        this.reservationId = reservationId;
        this.interval = interval;
        this.status = ReservationStatus.CREATED;
        this.type = type;
    }

    public String getReservationId() {
        return this.reservationId;
    }
}