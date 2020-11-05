package se.hernebring.ovningar20;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AfterOneMonth {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate afterOneMonth = date.plusMonths(1);
        System.out.println(afterOneMonth.format(DateTimeFormatter.ISO_DATE));
    }
}
