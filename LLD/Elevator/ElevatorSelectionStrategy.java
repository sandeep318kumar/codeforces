import java.util.List;
interface ElevatorSelectionStrategy {
    ElevatorController selectElevator(List<ElevatorController> controllers, int floorNo, ElevatorDirection dir);
}