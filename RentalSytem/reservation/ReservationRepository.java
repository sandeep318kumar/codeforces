package reservation;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import vehicle.Vehicle;

public class ReservationRepository {
    private HashMap<String, Reservation> reservations = new HashMap<>();

    public void save(Reservation reservation) {
        reservations.put(reservation.getReservationId(), reservation);
    }

    public Reservation  getReservationById(String id) {
        return reservations.get(id);
    }

    public List<Reservation> getReservationByVehicle(Vehicle vehicle) {
        List<Reservation> result = new ArrayList<>();
        for(Reservation r: reservations.values()) {
            if(r.vehicle.equals(vehicle)) {
                result.add(r);
            }
        }
        return result;
    }

    public void removeReservation(String id) {
        reservations.remove(id);
    }
}