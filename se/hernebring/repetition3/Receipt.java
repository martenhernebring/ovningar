package se.hernebring.repetition3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class Receipt {
    private Instant date;
    private Map<String, Long> wares;
    private long sum = 0L;
    private static final double MOMS = 0.25;
    private static final Locale LOCALE = new Locale("Sv", "se");
    private static final ZoneId ZONE = ZoneId.of("Europe/Stockholm");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss", LOCALE);

    public Receipt() {
        date = Instant.now();
        wares = new LinkedHashMap<>();
    }

    public void print(String header) {
        System.out.println(header);
        System.out.println(this);
    }

    public void print(String header, BufferedWriter output) throws IOException {
        output.write(String.format("%s%n", header));
        output.write(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ZonedDateTime localTime = date.atZone(ZONE);
        builder.append(String.format(LOCALE, "Datum: %s%n", localTime.format(FORMATTER)));
        for (Entry<String, Long> ware : wares.entrySet()) {
            builder.append(String.format(LOCALE, "%s %.2f%n", ware.getKey(), (double) ware.getValue() / 100));
        }
        double printSum = (double) sum / 100;
        builder.append(String.format(LOCALE, "TOTAL %.2f Kr%n", printSum));
        double moms = printSum * Receipt.MOMS;
        builder.append(String.format(LOCALE, "Moms: %.2f, Excl moms: %.2f%n", moms, printSum - moms));
        return builder.toString();
    }

    public void addWare(String description, long cents) {
        if (cents <= 0) {
            throw new IllegalArgumentException("Only positive values may be entered.");
        }
        wares.put(description, cents);
        sum += cents;
        date = Instant.now();
    }
}
