package store;
import vehicle.VehicleInventoryManager;

public class Store {
    public String storeId;
    public Location location;
    public VehicleInventoryManager vehicleInventoryManager;

    public Store(String storeId, Location location) {
        this.storeId = storeId;
        this.location = location;
        this.vehicleInventoryManager = new VehicleInventoryManager();
    }
}