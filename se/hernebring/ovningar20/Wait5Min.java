package se.hernebring.ovningar20;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Wait5Min {
    public static void main(String[] args) {
        ZoneId SWEDEN = ZoneId.of("Europe/Stockholm");
        ZoneId NEW_YORK = ZoneId.of("America/New_York");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("hh:mm:ss");
                
        while (true) {
            ZonedDateTime SWEDISH_TIME = ZonedDateTime.now(SWEDEN);
            ZonedDateTime NEW_YORK_TIME = SWEDISH_TIME.withZoneSameInstant(NEW_YORK);

            String SWEDISH_LOCAL = SWEDISH_TIME.format(outputFormat);
            String NEW_YORK_LOCAL = NEW_YORK_TIME.format(outputFormat);

            System.out.printf("Klockan är nu %s i Göteborg och %s i New York.%n", SWEDISH_LOCAL, NEW_YORK_LOCAL);
            sleep5min();
        }
    }

    static void sleep5min() {
        sleepMilliSeconds(5 * 60 * 1000);
    }

    static void sleepMilliSeconds(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
