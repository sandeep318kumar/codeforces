import java.util.List;
class LeastBusyStrategy implements ElevatorSelectionStrategy {
    public ElevatorController selectElevator(List<ElevatorController> controllers, int floorNo, ElevatorDirection dir) {
        ElevatorController best = null;
        int leastBusy = Integer.MAX_VALUE;

        for(ElevatorController ec: controllers) {
            if(ec.getLoad() < leastBusy) {
                leastBusy = ec.getLoad();
                best = ec;
            }
        }

        if(best == null) {
            controllers.get(0);
        }
        return best;
    }
}