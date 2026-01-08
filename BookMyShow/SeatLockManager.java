import java.util.List;

class SeatLockManager {

    public boolean lockSeats(List<ShowSeat> seats) {
        System.out.println("[SeatLock] Attempting to lock seats...");
        synchronized(this) {
            for(ShowSeat seat: seats) {
                if(seat.getStatus() != SeatStatus.AVAILABLE) {
                    System.out.println("[SeatLock] Seat already booked: " + seat.seat.seatId);
                    return false;
                }
            }

            // lock all seats.
            for(ShowSeat seat: seats) {
                if(!seat.lock()) {
                    releaseSeats(seats);
                    return false;
                }
            }
            return true;
        }
    }

    public  void confirmSeats (List<ShowSeat> seats) {
        seats.forEach(ShowSeat::confirm);
    }

    public  void releaseSeats(List<ShowSeat> seats) {
        seats.forEach(ShowSeat::release);
    }
}