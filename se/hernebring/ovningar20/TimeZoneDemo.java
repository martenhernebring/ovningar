package se.hernebring.ovningar20;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneDemo {

    public static void main(String[] args) {
        ZoneId SWEDEN = ZoneId.of("Europe/Stockholm");
        ZoneId NEW_YORK = ZoneId.of("America/New_York");
        
        ZonedDateTime SWEDISH_TIME = ZonedDateTime.now(SWEDEN);
        ZonedDateTime NEW_YORK_TIME = 
                SWEDISH_TIME.withZoneSameInstant(NEW_YORK);
        
        DateTimeFormatter outputFormat = 
                DateTimeFormatter.ofPattern("hh:mm:ss");
        
        String SWEDISH_LOCAL = SWEDISH_TIME.format(outputFormat);
        String NEW_YORK_LOCAL = NEW_YORK_TIME.format(outputFormat);
        
        System.out.printf("Klockan är %s i Göteborg och %s i New York.%n", SWEDISH_LOCAL, NEW_YORK_LOCAL);
    }
}
