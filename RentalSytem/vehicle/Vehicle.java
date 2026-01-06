package vehicle;
import enums.VehicleType;
import enums.VehicleStatus;
public class Vehicle {
    public String vehicleNo;
    public VehicleType vehicleType;
    public VehicleStatus vehicleStatus;

    public Vehicle(String vehicleNo, VehicleType vehicletype) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}