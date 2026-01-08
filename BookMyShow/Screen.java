import java.util.List;
import java.util.ArrayList;

class Screen {
    public String id;
    List<Seat> seats;

    Screen(String id) {
        this.id = id;
        this.seats = new ArrayList<>();
        System.out.println("[Screen] Created screen: " + id);
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
        System.out.println("[Screen] Seat added: " + seat.seatId + " to screen: " + id);
    }

    public List<Seat> getSeats() {
        return seats;
    }
}