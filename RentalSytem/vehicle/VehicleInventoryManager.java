package vehicle;
import java.util.List;
import java.util.ArrayList;

import enums.VehicleType;
import enums.VehicleStatus;

public class VehicleInventoryManager {
    List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    public List<Vehicle> getAvailableVehicles(VehicleType type) {
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle v: vehicles) {
            if(v.vehicleType == type && v.vehicleStatus == VehicleStatus.AVAILABLE) {
                result.add(v);
            }
        }
        return result;
    }
    public void setVehicleStatus(Vehicle vehicle, VehicleStatus status) {
        vehicle.setVehicleStatus(status);
    }
}