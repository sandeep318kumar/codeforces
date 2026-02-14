import java.util.ArrayList;
import java.util.List;

class Runner {
    public static void main(String[] args) throws InterruptedException {
        ElevatorCar car1 = new ElevatorCar(1);
        ElevatorCar car2 = new ElevatorCar(2);

        ElevatorController c1 = new ElevatorController(car1);
        ElevatorController c2 = new ElevatorController(car2);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        t1.start();
        t2.start();


        List<ElevatorController> controllers = List.of(c1, c2);
        ElevatorSelectionStrategy strategy = new NearestElevatorStrategy();
        ElevatorScheduler scheduler = new ElevatorScheduler(controllers, strategy);

        ExternalDispatcher dispatcher = new ExternalDispatcher(scheduler);
        ExternalButton externalButton = new ExternalButton(dispatcher);

        List<Floor> floors = new ArrayList<>();

        for(int i = 0;i<=10;i++) {
            floors.add(new Floor(i, externalButton, externalButton));
        }

        Building building = new Building(floors);

        InternalButton internalButton = new InternalButton(c1);

        // System.out.println("UP pressed at floor 3");
        // floors.get(3).pressUpButton();

        // System.out.println("Down pressed at floor 7");
        // floors.get(7).pressDownButton();

        // System.out.println("Passenger presses internal button to floor 5");
        // internalButton.pressButton(5);

        // // System.out.println("Switching strategy to least busy strategy");
        // // scheduler.setStrategy(new LeastBusyStrategy());

        // floors.get(7).pressUpButton();

        // -------- Test Case 0 (original) --------
        System.out.println("\n=== Test Case 0: Basic Flow ===");
        floors.get(3).pressUpButton();
        floors.get(7).pressDownButton();
        internalButton.pressButton(5);

        Thread.sleep(2000);

        // -------- Test Case 1 --------
        System.out.println("\n=== Test Case 1: Multiple External Requests ===");
        floors.get(2).pressUpButton();
        floors.get(8).pressDownButton();
        floors.get(6).pressUpButton();

        Thread.sleep(1500);

        // -------- Test Case 2 --------
        System.out.println("\n=== Test Case 2: Internal While Moving ===");
        internalButton.pressButton(9);

        Thread.sleep(1500);

        // -------- Test Case 3 --------
        System.out.println("\n=== Test Case 3: Duplicate Requests ===");
        floors.get(4).pressUpButton();
        floors.get(4).pressUpButton();

        Thread.sleep(1500);

        // -------- Test Case 4 --------
        System.out.println("\n=== Test Case 4: Both Elevators Busy ===");
        floors.get(1).pressUpButton();
        floors.get(10).pressDownButton();
        floors.get(3).pressUpButton();
        floors.get(7).pressDownButton();

        Thread.sleep(2000);

        // -------- Test Case 5 --------
        System.out.println("\n=== Test Case 5: Edge Floors ===");
        floors.get(0).pressUpButton();
        floors.get(10).pressDownButton();
    }
}