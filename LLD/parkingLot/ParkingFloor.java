import java.util.List;
class ParkingFloor {
    private final int floorNo;
    private final List<ParkingSpot> spots;

    ParkingFloor(int floorNo, List<ParkingSpot> spots) {
        this.floorNo = floorNo;
        this.spots = spots;
    }

    public List<ParkingSpot> getAvailableSpots(Vehicle vehicle) {
        return spots.stream().filter(s -> s.canFit(vehicle)).toList();
    }
}