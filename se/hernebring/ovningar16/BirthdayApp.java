package se.hernebring.ovningar16;

import java.time.LocalDate;

public class BirthdayApp {
    public static void main(String[] args) {
        BirthdayReader reader = new BirthdayReader("fodelse_namn.txt");
        LocalDate today = LocalDate.now();
        reader.printUpcoming(today);
    }
}
