package se.hernebring.extra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordCounter {
    private Path source1;
    private Path source2;
    private Map<String, Integer> counter;
    private int words;

    public WordCounter(Path source1, Path source2) {
        this.source1 = source1;
        this.source2 = source2;
        counter = new HashMap<>();
        words = 0;
    }

    public void readAllLines() throws IOException {
        List<String> lines1 = Files.readAllLines(source1);
        List<String> lines2 = Files.readAllLines(source2);
        for (String line : lines1) {
            add(line);
        }
        for (String line : lines2) {
            add(line);
        }
    }

    public void add(String line) {
        if (line == null) {
            return;
        }
        String[] lineWords = line.split("[\\s,.:;()-]+");
        for (String lineWord : lineWords) {
            if (lineWord.isBlank()) {
                continue;
            }
            words++;
            String word = lineWord.toLowerCase();
            if (counter.containsKey(word)) {
                counter.put(word, counter.get(word) + 1);
            } else {
                counter.put(word, 1);
            }
        }
    }

    public void writeResult() {
        String date = Instant.now().atZone(ZoneId.of("Europe/Stockholm"))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));

        System.out.println("Filename1 " + source1);
        System.out.println("Filename2 " + source2);
        System.out.println("Date: " + date);
        System.out.println("Words processed: " + words);
        for (Entry<String, Integer> entry : counter.entrySet()) {
            System.out.printf("%s, frekvens: %s%n", entry.getKey(), entry.getValue());
        }
    }
}
