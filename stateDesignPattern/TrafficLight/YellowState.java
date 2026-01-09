class YellowState implements TrafficState {
    public void action(TrafficLight signal) {
        // 
        System.out.println("Light is Yellow now!");
        signal.setState(new RedState());
    }
}