package se.hernebring.tenta.u1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordCounter {
    private Path source;
    private String outputFile;
    private Map<String, Integer> counter;
    private int words;

    public WordCounter(Path source, String outputFile) {
        this.source = source;
        this.outputFile = outputFile;
        counter = new HashMap<>();
        words = 0;
    }

    public void readAllLines() throws IOException {
        List<String> lines = Files.readAllLines(source);
        for (String line : lines) {
            add(line);
        }
    }

    public void add(String line) {
        if (line == null) {
            return;
        }
        String[] lineWords = line.split("[\\s,.;]+");
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

    public void writeResult() throws IOException {
        String date = Instant.now().atZone(ZoneId.of("Europe/Stockholm"))
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        int unique = extractUnique();
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(outputFile), StandardOpenOption.CREATE_NEW)) {
            writer.write("Filename: " + source);
            writer.newLine();
            writer.write("Date: " + date);
            writer.newLine();
            writer.write("Words processed: " + words);
            writer.newLine();
            writer.write("Total unique words: " + unique);
        }
    }

    private int extractUnique() {
        int uniqueWords = 0;
        for(Entry<String,Integer> entry: counter.entrySet()){
            if(entry.getValue() == 1){
                uniqueWords++;
            }
        }
        return uniqueWords;
    }
}
