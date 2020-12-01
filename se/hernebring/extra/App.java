package se.hernebring.extra;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        if (args.length != 2 || !args[0].endsWith(".txt") || !args[1].endsWith(".txt") || args[0].equals(args[1])) {
            System.err.println("Usage WordCount [from filename.txt] [result in other filename.txt");
        } else { // two different txt-files
            Path source1 = checkIfExist(args[0]);
            Path source2 = checkIfExist(args[1]);
            WordCounter wordCounter = new WordCounter(source1, source2);
            try {
                wordCounter.readAllLines();
            } catch (IOException ex) {
                System.err.printf("Problems reading %s. Try again with different files%n", source1, source2);
                System.exit(1);
            }
            wordCounter.writeResult();
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
