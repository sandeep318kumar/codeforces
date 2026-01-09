class RedState implements TrafficState {
    public void action(TrafficLight signal) {
        // 
        System.out.println("Light is Red now!");
        signal.setState(new GreenState());
    }
}