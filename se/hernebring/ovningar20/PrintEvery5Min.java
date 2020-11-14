package se.hernebring.ovningar20;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PrintEvery5Min {
    public static void main(String[] args) {
        ZoneId SWEDEN = ZoneId.of("Europe/Stockholm");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("hh:mm:ss");
        String SWEDISH_LOCAL_LAST5_PREVIOUS = null;
        while (true) {
            ZonedDateTime SWEDISH_TIME = ZonedDateTime.now(SWEDEN);
            ZonedDateTime SWEDISH_TIME_LAST5 = SWEDISH_TIME.truncatedTo(ChronoUnit.HOURS)
                                .plusMinutes(5 * (SWEDISH_TIME.getMinute() / 5));
            
            String SWEDISH_LOCAL_LAST5 = SWEDISH_TIME_LAST5.format(outputFormat);
            
            if(!SWEDISH_LOCAL_LAST5.equals(SWEDISH_LOCAL_LAST5_PREVIOUS)){
                System.out.printf("Klockan är nu %s i Göteborg.%n", SWEDISH_LOCAL_LAST5);
            }

            SWEDISH_LOCAL_LAST5_PREVIOUS = SWEDISH_LOCAL_LAST5;
        }
    }
}
