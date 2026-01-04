import java.util.Collections;
import java.util.PriorityQueue;

class ElevatorController implements Runnable {
    public final ElevatorCar elevator;
    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMaxPQ;

    ElevatorController(ElevatorCar elevatorCar) {
        this.elevator = elevatorCar;

        this.upMinPQ = new PriorityQueue<>();
        this.downMaxPQ = new PriorityQueue<>(Collections.reverseOrder());
    }

    public int getLoad() {
        return upMinPQ.size() + downMaxPQ.size();
    }

    public synchronized void submitRequest(int destinationFloor) {
        System.out.println("Request details: destination floor: " + destinationFloor + " accepted by elevator: " + elevator.getId());

        if(destinationFloor == elevator.getNextFloorStoppage()) {
            // already at this floor.
            elevator.getDoor().openDoor();
            return;
        }

        if(destinationFloor < elevator.getNextFloorStoppage()) {
            if(!downMaxPQ.contains(destinationFloor)) {
                downMaxPQ.add(destinationFloor);
            }
        }

        if(destinationFloor > elevator.getNextFloorStoppage()) {
            if(!upMinPQ.contains(destinationFloor)) {
                upMinPQ.add(destinationFloor);
            }
        }

        // move the elevator.
        // controlElevator();
        notify();
    }

    @Override
    public void run() {
        try {
            controlElevator();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(
                "Elevator Controller thread interrupted for elevator "
                + elevator.getId()
            );
        }
    }

    public void controlElevator() throws InterruptedException {
        while(true) {
            synchronized (this) {    
                while(upMinPQ.isEmpty() && downMaxPQ.isEmpty()) {
                    // no request.
                    try {
                        System.out.println("Elevator: " + elevator.getId() + " is IDLE");
                        elevator.setMovingDirection(ElevatorDirection.IDLE);
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            while(!upMinPQ.isEmpty()) {
                int floor = upMinPQ.poll();
                elevator.moveElevator(floor);
            }

            while(!downMaxPQ.isEmpty()) {
                int floor = downMaxPQ.poll();
                elevator.moveElevator(floor);
            }
        }
    }
}