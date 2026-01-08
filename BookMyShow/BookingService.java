import java.util.UUID;
import java.util.List;

class BookingService {
    private SeatLockManager lockManager  = new SeatLockManager();
    private Payment payment = new Payment();

    public Booking createBooking(User user, Show show, List<ShowSeat> seats) {
        System.out.println("[BookingService] Booking request by user: " + user.name);

        synchronized (show) {    
            if(!lockManager.lockSeats(seats)) {
                throw new RuntimeException("Seats are already booked");
            }
            try {
                double totalAmount = seats.stream().mapToDouble(s -> s.seat.price).sum();
                System.out.println("[BookingService] Total amount: " + totalAmount);


                if(!payment.makePayment(totalAmount)) {
                    lockManager.releaseSeats(seats);
                    throw new RuntimeException("Payment failed");
                }

                lockManager.confirmSeats(seats);

                Booking booking = new Booking(UUID.randomUUID().toString(), user, show, seats);
                booking.confirm();
                System.out.println("[BookingService] Booking successful: " + booking.bookingId);

                return booking;
            } catch (Exception e) {
                System.out.println("[BookingService] Error occurred, rolling back...");

                lockManager.releaseSeats(seats);
                throw e;
            }
        }
    }
}