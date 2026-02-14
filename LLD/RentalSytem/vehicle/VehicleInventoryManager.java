package vehicle;
import java.util.List;
import java.util.ArrayList;

import enums.VehicleType;
import enums.VehicleStatus;

public class VehicleInventoryManager {
    List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
        System.out.println("Vehicle " + vehicle.vehicleNo + " added to system");
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
        System.out.println("Vehicle " + vehicle.vehicleNo + " removed from system");

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
        System.out.println("Vehicle " + vehicle.vehicleNo + " status set to: " + status);

    }
}