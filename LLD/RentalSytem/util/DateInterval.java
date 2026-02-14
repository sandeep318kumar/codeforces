package util;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateInterval {
    public LocalDate start;
    public LocalDate end;

    public DateInterval(LocalDate start, LocalDate end) {
        if(end.isBefore(start)) {
            throw new IllegalStateException("Invalid date interval");
        }
        this.start = start;
        this.end = end;
    }

    public boolean isOverlapping(DateInterval other) {
        return !(this.end.isBefore(other.start) || this.start.isAfter(other.end));
    }

    public long getDays() {
        return ChronoUnit.DAYS.between(start, end) + 1;
    }
}