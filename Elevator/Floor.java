class Floor {
    private final int floorNo;
    private final ExternalButton upButton;
    private final ExternalButton downButton;

    Floor(int floorNo, ExternalButton upButton, ExternalButton downButton) {
        this.floorNo = floorNo;
        this.upButton = upButton;
        this.downButton = downButton;
    }

    public void pressUpButton() {
        upButton.pressButton(floorNo, ElevatorDirection.UP);
    }

    public void pressDownButton() {
        downButton.pressButton(floorNo, ElevatorDirection.DOWN);
    }

}