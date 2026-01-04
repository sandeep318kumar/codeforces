class InternalButton {
    private final ElevatorController controller;

    InternalButton(ElevatorController controller) {
        this.controller = controller;
    }

    public void pressButton(int floor) throws InterruptedException {
        controller.submitRequest(floor);
    }
}