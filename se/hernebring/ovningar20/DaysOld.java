package se.hernebring.ovningar20;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DaysOld {
    public static void main(String[] args) {
        LocalDate birth = null;
        LocalDate today = LocalDate.now();
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.println("Vilket datum är du född? (ÅÅÅÅ-MM-DD)");
                String birthDay = scan.nextLine();
                try {
                    birth = LocalDate.parse(birthDay, DateTimeFormatter.ISO_DATE);
                    if(birth.isBefore(today)) {
                        break; 
                    }
                    System.out.println("Inga framtidsdatum tack.");
                } catch (DateTimeParseException ex) {
                    System.out.println("Ej korrekt datum!");
                }
            }
        }

        LocalDate now = LocalDate.now();
        long days = ChronoUnit.DAYS.between(birth, now);
        System.out.println("Du är " + days + " dagar gammal.");
    }
}
