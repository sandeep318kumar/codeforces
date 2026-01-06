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
        VehicleRentalSystem system = new VehicleRentalSystem();

        Store store = new Store("S1", new Location("Bangalore", "MG Road"));
        system.addStore(store);

        Vehicle bike = new Vehicle("KA01", VehicleType.TWO_WHEELER);
        Vehicle car =  new Vehicle("KA21", VehicleType.FOUR_WHEELER);

        store.vehicleInventoryManager.addVehicle(bike);
        store.vehicleInventoryManager.addVehicle(car);

        User user = new User("U1", "Sandeep");

        ReservationRepository repo = new ReservationRepository();
        ReservationManager manager = new ReservationManager(repo);

        DateInterval interval = new DateInterval(LocalDate.now(), LocalDate.now().plusDays(2));

        Reservation reservation = manager.createReservation(user, car, interval, ReservationType.DAILY);

        BillManager billManager = new BillManager(new DailyBillingStrategy());
        Bill bill = billManager.generateBill(reservation);

        PaymentManager paymentManager = new PaymentManager(new UpiPayment());
        paymentManager.makePayment(bill.amount);

        reservation.status = ReservationStatus.CONFIRMED;
    }
}