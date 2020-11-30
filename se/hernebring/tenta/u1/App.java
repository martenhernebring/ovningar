package se.hernebring.tenta.u1;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.time.Instant;

public class App {
    public static void main(String[] args) {
        if (args.length != 2 || !args[0].endsWith(".txt") || !args[1].endsWith(".txt") || args[0].equals(args[1])) {
            System.err.println("Usage WordCount [from filename.txt] [result in other filename.txt");
        } else { // two different txt-files
            Path source = checkIfExist(args[0]);
            WordCounter wordCounter = new WordCounter(source, args[1]);
            Instant before = Instant.now();
            try {
                wordCounter.readAllLines();
            } catch (IOException ex) {
                System.err.printf("Problems reading %s. Try again with different file%n", source);
                System.exit(1);
            }
            try {
                wordCounter.writeResult();
            } catch (IOException ex) {
                System.err.printf("Problems writing to %s. Try different output file-name%n", source);
                System.exit(1);
            }
            Instant after = Instant.now();
            System.out.println("Time " + (after.toEpochMilli() - before.toEpochMilli()));
        }
    }

    private static Path checkIfExist(String inputFile) {
        try {
            return Path.of(inputFile).toAbsolutePath().normalize();
        } catch (InvalidPathException ex) {
            System.err.println(inputFile + " does not exist.");
            System.err.println("Usage WordCount [existing filename.txt] [non-existing filename.txt");
            System.exit(1);
        }
        return null;
    }
}
