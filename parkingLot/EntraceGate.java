import java.util.List;

class EntraceGate {
    private final List<ParkingFloor> floors;
    private final SpotSelectionStrategy spotStrategy;

    EntraceGate(List<ParkingFloor> floors, SpotSelectionStrategy spotStrategy) {
        this.floors = floors;
        this.spotStrategy = spotStrategy;
    }

    public Ticket generateTicket(Vehicle vehicle) {
        ParkingSpot spot = spotStrategy.findSpot(floors, vehicle);
        if(spot == null) throw new RuntimeException("Parking Full");
        spot.park(vehicle);
        return new Ticket(vehicle, spot);
    }
}