class Door {
    private DoorState state;

    Door() {
        this.state = DoorState.DOOR_CLOSED;
    }
    public void openDoor() {
        this.state = DoorState.DOOR_OPEN;
        System.out.println("Door opened");
    }
    public void closeDoor() {
        this.state = DoorState.DOOR_CLOSED;
        System.out.println("Door closed");
    }
    public DoorState getState() {
        return state;
    }
}