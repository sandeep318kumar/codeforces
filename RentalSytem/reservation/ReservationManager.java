package reservation;

import user.User;
import vehicle.Vehicle;
import enums.ReservationType;
import util.DateInterval;

import java.util.List;
import java.util.UUID;

public class ReservationManager {
    ReservationRepository reservationRepo;
    
    public ReservationManager(ReservationRepository repo) {
        this.reservationRepo = repo;
    }

    public Reservation createReservation(User user, Vehicle vehicle, DateInterval interval, ReservationType type) {
        String id = UUID.randomUUID().toString();
        Reservation reservation = new Reservation(user, vehicle, id, interval, type);
        reservationRepo.save(reservation);
        return reservation;
    }

    public void removeReservation(String id) {
        reservationRepo.removeReservation(id);
    }

    public List<Reservation> getAllReservationForAVehicle(Vehicle vehicle) {
        return reservationRepo.getReservationByVehicle(vehicle);
    }
}