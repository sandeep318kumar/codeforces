import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.*;
import java.util.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Arrays;

class Runner {
    public static void main(String[] args) throws InterruptedException {
        City bangalore = new City("Bangalore");

        Theatre inox = new Theatre("12", "inox", "MG road");
        
        Screen screen = new Screen("screen1");

        Seat s1 = new Seat("A1", SeatType.REGULAR, 200);
        Seat s2 = new Seat("A2", SeatType.PREMIUM, 400);
        List<Seat> seats = Arrays.asList(s1, s2);
        screen.addSeat(s1);
        screen.addSeat(s2);

        inox.AddScreen(screen);
        bangalore.addTheatre(inox);

        Movie movie = new Movie("movie1", "Durandhar", 196);

        Show show = new Show("firstShow", movie, screen, LocalDateTime.now());
        User u1 = new User("u1", "Minipha");
        User u2 = new User("u2", "Elepha");

        BookingService bookingService = new BookingService();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(2);

        AtomicInteger successCount = new AtomicInteger(0);
        AtomicInteger failureCount = new AtomicInteger(0);

        // same seat for both threads;
        ShowSeat targetSeat = show.getAvailableSeats().get(0);

        Runnable task1 = () -> {
            try {
                startLatch.await(); // wait for simultaneous start
                bookingService.createBooking(u1, show, List.of(targetSeat));
                successCount.incrementAndGet();
                System.out.println("[TEST] Booking success by " + u1.name);
            } catch (Exception e) {
                failureCount.incrementAndGet();
                System.out.println("[TEST] Booking failed for " + u1.name);
            } finally {
                doneLatch.countDown();
            }
        };

        Runnable task2 = () -> {
            try {
                startLatch.await();
                bookingService.createBooking(u2, show, List.of(targetSeat));
                successCount.incrementAndGet();
                System.out.println("[TEST] Booking success by " + u2.name);
            } catch (Exception e) {
                failureCount.incrementAndGet();
                System.out.println("[TEST] Booking failed for " + u2.name);
            } finally {
                doneLatch.countDown();
            }
        };

        executor.submit(task1);
        executor.submit(task2);

        System.out.println("\n[TEST] Starting concurrent booking...");
        startLatch.countDown(); // 🚀 both threads start here

        doneLatch.await(); // wait for completion
        executor.shutdown();

        System.out.println("\n========== TEST RESULT ==========");
        System.out.println("Success count: " + successCount.get());
        System.out.println("Failure count: " + failureCount.get());

        if (successCount.get() == 1 && failureCount.get() == 1) {
            System.out.println("✅ CONCURRENCY TEST PASSED");
        } else {
            System.out.println("❌ CONCURRENCY TEST FAILED");
        }
    }
}