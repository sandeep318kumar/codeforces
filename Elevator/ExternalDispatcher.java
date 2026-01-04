class ExternalDispatcher {
    private final ElevatorScheduler scheduler;

    ExternalDispatcher(ElevatorScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void submitExternalRequest(int floorNo, ElevatorDirection dir) {
        ElevatorController controller = scheduler.assignElevator(floorNo, dir);
        controller.submitRequest(floorNo);
    }
}