import java.time.LocalDateTime;
import java.util.UUID;

class Ticket {
    private final String ticketId;
    private final LocalDateTime entryTime;
    private ParkingSpot spot;
    private Vehicle vehicle;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = UUID.randomUUID().toString();
        this.entryTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.spot = spot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    public ParkingSpot getSpot() {
        return spot;
    }
}