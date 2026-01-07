import store.Store;
import store.Location;
import vehicle.Vehicle;
import user.User;
import vehicle.VehicleInventoryManager;
import reservation.ReservationRepository;
import reservation.ReservationManager;
import reservation.Reservation;
import bill.Bill;
import bill.BillManager;
import bill.BillingStrategy;
import bill.DailyBillingStrategy;
import payment.PaymentManager;
import payment.UpiPayment;
import enums.VehicleType;
import enums.ReservationType;
import enums.ReservationStatus;
import util.DateInterval;
import java.time.LocalDate;

class Runner {
    public static void main(String[] args) {
        System.out.println("===== Vehicle Rental System Tests =====");

        VehicleRentalSystem system = new VehicleRentalSystem();

        Store store = new Store("S1", new Location("Bangalore", "MG Road"));
        system.addStore(store);

        Vehicle car = new Vehicle("KA21", VehicleType.FOUR_WHEELER);
        Vehicle bike = new Vehicle("KA01", VehicleType.TWO_WHEELER);

        store.vehicleInventoryManager.addVehicle(car);
        store.vehicleInventoryManager.addVehicle(bike);

        User user1 = new User("U1", "Sandeep");
        User user2 = new User("U2", "Rahul");

        ReservationRepository repo = new ReservationRepository();
        ReservationManager manager = new ReservationManager(repo);

        /* ================================
           Test Case 1: Happy Path
           ================================ */
        System.out.println("\n=== Test Case 1: Happy Path ===");
        DateInterval interval1 =
                new DateInterval(LocalDate.now(), LocalDate.now().plusDays(2));

        Reservation r1 = manager.createReservation(user1, car, interval1, ReservationType.DAILY);
        BillManager billManager = new BillManager(new DailyBillingStrategy());
        Bill bill = billManager.generateBill(r1);

        PaymentManager paymentManager = new PaymentManager(new UpiPayment());
        paymentManager.makePayment(bill.amount);
        r1.status = ReservationStatus.CONFIRMED;

        System.out.println("Reservation confirmed for user: " + user1.getName());

        /* ================================
           Test Case 2: Double Booking Same Vehicle
           ================================ */
        System.out.println("\n=== Test Case 2: Double Booking Same Vehicle ===");
        try {
            manager.createReservation(
                    user2,
                    car,
                    new DateInterval(LocalDate.now().plusDays(1),
                                     LocalDate.now().plusDays(3)),
                    ReservationType.DAILY
            );
        } catch (Exception e) {
            System.out.println("Expected failure: " + e.getMessage());
        }

        /* ================================
           Test Case 3: Booking Another Vehicle
           ================================ */
        System.out.println("\n=== Test Case 3: Booking Another Vehicle ===");
        Reservation r2 = manager.createReservation(
                user2,
                bike,
                interval1,
                ReservationType.DAILY
        );
        System.out.println("Reservation success for bike");

        /* ================================
           Test Case 4: Invalid Date Interval
           ================================ */
        System.out.println("\n=== Test Case 4: Invalid Date Interval ===");
        try {
            manager.createReservation(
                    user1,
                    bike,
                    new DateInterval(LocalDate.now().plusDays(5),
                                     LocalDate.now().plusDays(1)),
                    ReservationType.DAILY
            );
        } catch (Exception e) {
            System.out.println("Expected failure: " + e.getMessage());
        }

        /* ================================
           Test Case 5: Concurrency Test
           ================================ */
        System.out.println("\n=== Test Case 5: Concurrent Booking ===");

        Vehicle sharedCar = new Vehicle("KA99", VehicleType.FOUR_WHEELER);
        store.vehicleInventoryManager.addVehicle(sharedCar);

        Runnable task = () -> {
            try {
                manager.createReservation(
                        new User("UX", "ConcurrentUser"),
                        sharedCar,
                        interval1,
                        ReservationType.DAILY
                );
                System.out.println(Thread.currentThread().getName() + ": Booking SUCCESS");
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + ": Booking FAILED");
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        /* ================================
           Test Case 6: Cancellation
           ================================ */
        System.out.println("\n=== Test Case 6: Cancellation ===");
        manager.cancelReservation(r1.getReservationId());
        System.out.println("Reservation cancelled, vehicle available again");

        System.out.println("\n===== All Tests Completed =====");
    }
}