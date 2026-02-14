import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

class Show {
    public String id;
    public Movie movie;
    public Screen screen;
    LocalDateTime startTime;
    final List<ShowSeat> showSeats;

    Show(String id, Movie movie, Screen screen, LocalDateTime startTime) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        System.out.println("[Show] Creating show: " + id + " for movie: " + movie.name);

        this.showSeats = new ArrayList<>();
        for(Seat seat : screen.getSeats()) {
            showSeats.add(new ShowSeat(seat));
        }
        System.out.println("[Show] Total seats initialized: " + showSeats.size());
    }

    public List<ShowSeat> getAvailableSeats() {
        List<ShowSeat> available = showSeats.stream().filter(s -> s.getStatus() == SeatStatus.AVAILABLE).toList();
        System.out.println("[Show] Available seats count: " + available.size());
        return available;
    }
}