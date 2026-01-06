package util;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateInterval {
    LocalDate start;
    LocalDate end;

    public DateInterval(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public long getDays() {
        return ChronoUnit.DAYS.between(start, end) + 1;
    }
}