class GreenState implements TrafficState {
    public void action(TrafficLight signal) {
        // 
        System.out.println("Light is Green now!");
        signal.setState(new YellowState());
    }
}