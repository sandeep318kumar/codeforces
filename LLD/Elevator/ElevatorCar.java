import static java.lang.Thread.sleep;
class ElevatorCar {
    private int id;
    private int currentFloor;
    private int nextFloorStoppage;
    private ElevatorDirection movingDir;
    private Door door;

    ElevatorCar(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.nextFloorStoppage = 0;
        this.movingDir = ElevatorDirection.IDLE;
        this.door = new Door();
    }

    public int getId() {
        return id;
    }

    public Door getDoor() {
        return door;
    }

    public int getNextFloorStoppage(){
        return nextFloorStoppage;
    }

    public ElevatorDirection getMovingDirection(){
        return movingDir;
    }

    public void setMovingDirection(ElevatorDirection dir) {
        this.movingDir = dir;
    }

    public void display() {
        System.out.println("Elevater: " + id + " current floor: " + currentFloor + " going: " + movingDir + " Destination: " + nextFloorStoppage);
    }

    public void moveElevator(int destinationFloor) throws InterruptedException {

        System.out.println("serving destinationFloor: " + destinationFloor + " by Elevator: " + id + " current floor: " + currentFloor );
        // decide the direction.
        this.nextFloorStoppage = destinationFloor;
        if(this.currentFloor == nextFloorStoppage) {
            // already at same floor.
        door.openDoor();
            sleep(1000);
            door.closeDoor();
            return;
        }
        
        door.closeDoor();
        int startFloor = this.currentFloor;
        if(currentFloor < nextFloorStoppage) {
            // going UP.
            movingDir = ElevatorDirection.UP;
            display();

            for(int i = startFloor + 1;i<=nextFloorStoppage;i++) {
                this.currentFloor = i;
                sleep(1000);
                // display();
            }
        } else {
            // going down.
            this.movingDir = ElevatorDirection.DOWN;
            display();

            for(int i = startFloor - 1;i>=nextFloorStoppage;i--) {
                this.currentFloor = i;
                sleep(1000);
                // display();
            }
        }
        door.openDoor();
        sleep(1000);
        door.closeDoor();
    }
}