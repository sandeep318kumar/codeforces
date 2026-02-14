import java.util.List;

import static java.lang.Thread.sleep;

class Runner {
    public static void main(String[] args) throws InterruptedException {
        ParkingSpot s1 = new ParkingSpot("S1", SpotType.TWO_WHEELER, 20);
        ParkingSpot s2 = new ParkingSpot("S2", SpotType.FOUR_WHEELER, 40);

        ParkingFloor floor = new ParkingFloor(1, List.of(s1, s2));
        List<ParkingFloor> floors = List.of(floor);

        ParkingAvailabilityDisplay display = new ParkingAvailabilityDisplay("MainEntranceDisplay");
        s1.addObserver(display);

        EntraceGate entrance = new EntraceGate(floors, new NearestToEntranceStrategy());

        Vehicle bike = new Vehicle("KA-01", VehicleType.TWO_WHEELER);
        Ticket ticket = entrance.generateTicket(bike);

        sleep(10000);

        PricingStrategy pricing = PricingFactory.get(PricingType.MINUTE, true);
        ExitGate exit = new ExitGate(pricing);
        PaymentStrategy payment = PaymentFactory.get(PaymentType.UPI);

        System.out.println("Amount: "+ exit.calculateCost(ticket));
        exit.processExit(ticket, payment);
        System.out.println("Spot empty: "+ s1.isEmpty());
    }
}