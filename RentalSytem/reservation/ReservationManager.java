package reservation;

import user.User;
import vehicle.Vehicle;
import enums.ReservationType;
import enums.VehicleStatus;
import enums.ReservationStatus;
import util.DateInterval;

import java.util.List;
import java.util.UUID;

public class ReservationManager {
    ReservationRepository reservationRepo;
    
    public ReservationManager(ReservationRepository repo) {
        this.reservationRepo = repo;
    }

    public Reservation createReservation(User user, Vehicle vehicle, DateInterval interval, ReservationType type) {
        synchronized(vehicle) {
            // first check vehicle Availability.
            if(vehicle.vehicleStatus != VehicleStatus.AVAILABLE) {
                throw new IllegalStateException("Vehicle already reserved or in maintenance");
            }

            // check if dates are overlapping.
            List<Reservation> existing = reservationRepo.getReservationByVehicle(vehicle);
            for(Reservation r: existing) {
                if(r.interval.isOverlapping(interval)) {
                    throw new IllegalStateException("Vehicle already booked for this time interval");
                }
            }

            String id = UUID.randomUUID().toString();
            Reservation reservation = new Reservation(user, vehicle, id, interval, type);
            reservationRepo.save(reservation);
            System.out.println("Reservation with id: " + reservation.getReservationId() + " is successfull Vehicle: " + vehicle.vehicleNo + " Dates: " + interval.start + ", " + interval.end + " by user: " + user.getName());
            return reservation;
        }
    }

    public void cancelReservation(String id) {
        Reservation reservation = reservationRepo.getReservationById(id);
        reservation.status = ReservationStatus.CANCELLED;
        reservation.vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
        reservationRepo.removeReservation(id);
        System.out.println("Reservation with id: " + id + " removed from system");
    }

    public List<Reservation> getAllReservationForAVehicle(Vehicle vehicle) {
        return reservationRepo.getReservationByVehicle(vehicle);
    }
}