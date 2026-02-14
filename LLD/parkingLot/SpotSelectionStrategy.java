import java.util.List;

interface SpotSelectionStrategy {
    ParkingSpot findSpot (List<ParkingFloor> floors, Vehicle vehicle);
}