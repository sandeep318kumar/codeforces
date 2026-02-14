import java.util.List;

class NearestToEntranceStrategy implements SpotSelectionStrategy {
    public ParkingSpot findSpot (List<ParkingFloor> floors, Vehicle vehicle) {
        for(ParkingFloor pf: floors) {
            for(ParkingSpot s: pf.getAvailableSpots(vehicle))
                return s;
        }
        return null;
    }
}