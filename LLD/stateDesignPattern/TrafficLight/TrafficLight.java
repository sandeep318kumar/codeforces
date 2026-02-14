class TrafficLight {
    TrafficState state;

    TrafficLight() {
        this.state = new RedState();
    }

    public void setState(TrafficState state) {
        this.state = state;
    }

    public void changeState() {
        state.action(this);
    }
}