import java.util.List;

class NearestElevatorStrategy implements ElevatorSelectionStrategy {
    public ElevatorController selectElevator(List<ElevatorController> controllers, int floorNo, ElevatorDirection dir) {
        int minDistance = Integer.MAX_VALUE;
        ElevatorController best = null;

        for(ElevatorController ec: controllers) {
            int nextFloorStoppage = ec.elevator.getNextFloorStoppage();
            ElevatorDirection eDir = ec.elevator.getMovingDirection();

            boolean isInSameDirection = dir == eDir && ((eDir == ElevatorDirection.UP && nextFloorStoppage <= floorNo) || (eDir == ElevatorDirection.DOWN && nextFloorStoppage >= floorNo));
            int dist = Math.abs(floorNo - nextFloorStoppage);

            if(isInSameDirection && dist < minDistance) {
                minDistance = dist;
                best = ec;
            }
        }
        if(best == null) {
            // pick the idle one.
            for(ElevatorController ec: controllers) {
                if(ec.elevator.getMovingDirection() == ElevatorDirection.IDLE) {
                    best = ec;
                    break;
                }
            }
            if(best == null) {
                // no elevator in same direct and no one is idle the pick the first one.
                best = controllers.get(0);
            }
        }
        return best;
    }
}