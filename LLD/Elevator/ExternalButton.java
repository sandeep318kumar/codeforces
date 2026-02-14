class ExternalButton {
    private final ExternalDispatcher dispatcher;

    ExternalButton(ExternalDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void pressButton(int floor, ElevatorDirection dir) {
        dispatcher.submitExternalRequest(floor, dir);
    }
}