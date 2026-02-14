import java.util.List;

class Booking {
    public String bookingId;
    public User user;
    public Show show;
    public List<ShowSeat> seats;
    public BookingStatus status;

    Booking(String bookingId, User user, Show show, List<ShowSeat> seats) {
        this.bookingId = bookingId;
        this.user = user;
        this.show = show;
        this.status = BookingStatus.CREATED;
        this.seats = seats;
        System.out.println("[Booking] Created booking: " + bookingId +
        " | User: " + user.name +
        " | Seats: " + seats.size());
    }

    public void confirm() {
        this.status = BookingStatus.CONFIRMED;
    }
}