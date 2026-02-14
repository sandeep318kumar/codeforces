import java.util.List;

class NearestToElevatorStrategy implements SpotSelectionStrategy {
    public ParkingSpot findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        return new NearestToEntranceStrategy().findSpot(floors, vehicle);
    }
}