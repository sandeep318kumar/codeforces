import java.util.List;
import java.util.ArrayList;
class ParkingSpot {
    private final String spotID;
    private final SpotType type;
    private  boolean isEmpty = true;
    private final double basePrice;
    private Vehicle vehicle;
    private final List<ParkingObserver> observers = new ArrayList<>();

    ParkingSpot(String id, SpotType type, double basePrice) {
        this.spotID = id;
        this.type = type;
        this.basePrice = basePrice;
    }

    public boolean canFit(Vehicle vehicle) {
        return isEmpty && ((vehicle.getType() == VehicleType.TWO_WHEELER && type == SpotType.TWO_WHEELER) || 
        (vehicle.getType() == VehicleType.FOUR_WHEELER && type == SpotType.FOUR_WHEELER));
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = false;
    }

    public void unPark() {
        this.vehicle = null;
        this.isEmpty = false;
        notifyObservers();
    }

    public double getBasePrice() {
        return basePrice;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void addObserver(ParkingObserver observer) {
        observers.add(observer);
    }
    private void notifyObservers() {
        observers.forEach(o -> o.onSpotFreed(this));
    }

    public String getId() {
        return spotID;
    }
}