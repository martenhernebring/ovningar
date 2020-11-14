package se.hernebring.ovningar20;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class WaitAndPrintEvery5Min {

    final static ZoneId SWEDEN = ZoneId.of("Europe/Stockholm");
    final static DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("hh:mm:ss");
    static String SWEDISH_LOCAL_LAST5_PREVIOUS = null;

    public static void main(String[] args) {
        waitUntilNext5Min();
        printEvery5Min();
    }

    static void printEvery5Min(){
        while (true) {
            ZonedDateTime SWEDISH_TIME = ZonedDateTime.now(SWEDEN);
            ZonedDateTime SWEDISH_TIME_LAST5 = SWEDISH_TIME.truncatedTo(ChronoUnit.HOURS)
                                .plusMinutes(5 * (SWEDISH_TIME.getMinute() / 5));
            
            String SWEDISH_LOCAL_LAST5 = SWEDISH_TIME_LAST5.format(outputFormat);
            
            if(!SWEDISH_LOCAL_LAST5.equals(SWEDISH_LOCAL_LAST5_PREVIOUS)){
                System.out.printf("Klockan är nu %s i Göteborg.%n", SWEDISH_LOCAL_LAST5);
                sleep4min59sec();
                SWEDISH_LOCAL_LAST5_PREVIOUS = SWEDISH_LOCAL_LAST5;
            }
        }
    }

    static void waitUntilNext5Min(){
        while(true){
            ZonedDateTime SWEDISH_TIME = ZonedDateTime.now(SWEDEN);
            ZonedDateTime SWEDISH_TIME_LAST5 = SWEDISH_TIME.truncatedTo(ChronoUnit.HOURS)
                                .plusMinutes(5 * (SWEDISH_TIME.getMinute() / 5));
            
            String SWEDISH_LOCAL_LAST5 = SWEDISH_TIME_LAST5.format(outputFormat);
            
            if(!SWEDISH_LOCAL_LAST5.equals(SWEDISH_LOCAL_LAST5_PREVIOUS)){
                SWEDISH_LOCAL_LAST5_PREVIOUS = SWEDISH_LOCAL_LAST5;
                break;
            } else{
                sleep100ms();
            }
        }
    }

    static void sleep4min59sec() {
        try {
            Thread.sleep((4 * 60 + 59)* 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    static void sleep100ms() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
