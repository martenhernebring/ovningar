package se.hernebring.ovningar20;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodaysDate {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date.format(DateTimeFormatter.ISO_DATE));
    }
}
