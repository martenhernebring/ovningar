package se.hernebring.ovningar20;

import java.time.Duration;
import java.time.LocalDateTime;

public class DaysLeft {
    public static void main(String[] args) {
        LocalDateTime TODAY = LocalDateTime.now();
        LocalDateTime NEW_YEAR = LocalDateTime.of(TODAY.getYear()+1, 1, 1, 0, 0);
        Duration TO_NEW_YEAR = Duration.between(TODAY, NEW_YEAR);
        System.out.println(TO_NEW_YEAR.toDays() + " days 'til New Year.");
    }
}
