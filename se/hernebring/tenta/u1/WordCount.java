package se.hernebring.tenta.u1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WordCount {
    public static void main(String[] args) {
        if (args.length != 2 || !args[0].endsWith(".txt") || !args[1].endsWith(".txt") || args[0].equals(args[1])) {
            System.err.println("Usage WordCount [from filename.txt] [result in other filename.txt");
        } else { // two different txt-files
            String source = args[0];
            Path sourcePath = null;
            List<String> lines = null;
            try {
                sourcePath = Path.of(source).toAbsolutePath().normalize();
            } catch (InvalidPathException ex) {
                System.err.println(source + " does not exist.");
                System.err.println("Usage WordCount [existing filename.txt] [non-existing filename.txt");
                System.exit(1);
            }
            try {
                lines = Files.readAllLines(sourcePath);
            } catch (IOException ex) {
                System.err.println("Problems reading file. Try again with different file");
                System.exit(1);
            }
            List<String> words = extractWords(lines);
            List<String> uniqueWords = extractUnique(words);
            Instant time = Instant.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
            String date = time.atZone(ZoneId.of("Europe/Stockholm")).format(formatter);
            try (BufferedWriter writer = Files.newBufferedWriter(Path.of(args[1]), StandardOpenOption.CREATE_NEW)) {
                writer.write("Filename: " + sourcePath);
                writer.newLine();
                writer.write("Date: " + date);
                writer.newLine();
                writer.write("Words processed: " + words.size());
                writer.newLine();
                writer.write("Total unique words: " + uniqueWords.size());
            } catch (IOException ex) {
                System.err.println("Problems writing to file. Try different output file-name");
                System.exit(1);
            }
        }
    }

    private static List<String> extractUnique(List<String> words) {
        List<String> uniqueWords = new ArrayList<>(words);
        for (int i = uniqueWords.size() - 1; i > 0; i--) {
            boolean unique = true;
            String current = uniqueWords.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (current.equals(uniqueWords.get(j))) {
                    uniqueWords.remove(j);
                    i--;
                    unique = false;
                }
            }
            if (!unique) {
                uniqueWords.remove(i);
            }
        }
        return uniqueWords;
    }

    private static List<String> extractWords(List<String> lines) {
        List<String> words = new ArrayList<>();
        for (String line : lines) {
            if (!line.isEmpty()) {
                String[] lineWords = line.split("[\\s,.;]+");
                for (int i = 0; i < lineWords.length; i++) {
                    words.add(lineWords[i].toLowerCase());
                }
            }
        }
        return words;
    }
}
