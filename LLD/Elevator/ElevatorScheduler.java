import java.util.List;

class ElevatorScheduler {
    List<ElevatorController> controllers;
    ElevatorSelectionStrategy strategy;

    ElevatorScheduler(List<ElevatorController> controllers, ElevatorSelectionStrategy strategy) {
        this.controllers = controllers;
        this.strategy = strategy;
    }

    public void setStrategy(ElevatorSelectionStrategy strategy) {
        this.strategy = strategy;
    }

    public ElevatorController assignElevator(int floorNo, ElevatorDirection dir) {
        return strategy.selectElevator(controllers, floorNo, dir);
    }
}