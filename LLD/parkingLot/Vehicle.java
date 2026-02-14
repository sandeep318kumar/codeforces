
class Vehicle {
    private final String number;
    private final VehicleType vType;

    public Vehicle(String number, VehicleType vtype){
        this.number = number;
        this.vType = vtype;
    }

    public VehicleType getType() { 
        return vType;
    };
}