package se.hernebring.ovningar16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class BirthdayReader {
    List<BirthdayPerson> birthdays;

    public BirthdayReader(String file) {
        parse(file);
    }

    void parse(String file) {
        birthdays = new ArrayList<>();
        try (Stream<String> theFile = Files.lines(Path.of(file))) {
            theFile.forEach(line -> {
                if (!line.isBlank()) {
                    String[] data = line.split("\\s+");
                    LocalDate birth = LocalDate.parse(data[0], DateTimeFormatter.ISO_DATE);
                    birthdays.add(new BirthdayPerson(data[1], birth));
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Collections.sort(birthdays);
    }

    public void printUpcoming(LocalDate today) {
        BirthdayPerson birthday = new BirthdayPerson("birthday", today);
        int index = Collections.binarySearch(birthdays, birthday);
        if(index > 0){
            System.out.println("It is " + birthdays.get(index).getFirstName()
             + "'s birthday today!");
        } else {
            index -= index;
            daysUntil(birthday.getDayOfYear(), index);
        }
    }

    public void daysUntil(int today, int index) {
        int size = birthdays.size();
        for (int j = 0; j < size; j++) {
            int diff = birthdays.get(index).getDayOfYear() - today;
            if (diff < 0) {
                diff += 365;
            }
            System.out.println("It is " + diff + " days until " + birthdays.get(index).getFirstName() + " birthday.");
            index++;
            if (index >= size) {
                index = 0;
            }
        }
    }
}
