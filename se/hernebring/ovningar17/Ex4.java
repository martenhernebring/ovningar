package se.hernebring.ovningar17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Ex4 {
    // your code here
    private static void createData(Path file) throws IOException {
        int lines = ThreadLocalRandom.current().nextInt(50) + 10000;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile()))) {
            for (int i = 0; i < lines; ++i) {
                writer.append("hej\r\nhopp\r\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Path[] tempFiles = new Path[3];
        for (int i = 0; i < tempFiles.length; ++i) {
            tempFiles[i] = Files.createTempFile("temp", ".txt");
            tempFiles[i].toFile().deleteOnExit();
            createData(tempFiles[i]);
        }
        System.out.println("Done creating data.");
        for (int i = 0; i < 1000; ++i) {
            String filename = tempFiles[i % 3].toString();
            int oldCount = getNumberOfLines(filename);
            if (oldCount != getNumberOfLines(filename)) {
                System.out.println("Oops, something went wrong!");
                System.exit(-1);
            }
        }
        System.out.println("Done!");
    }

    Map<String, Integer> map = new HashMap<>();

    private static int getNumberOfLines(String filename) throws IOException {
        int lines = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
        while (reader.readLine() != null) lines++;
        } catch (FileNotFoundException ex) {
            System.out.println(filename+" not found.");
        }
        return lines;
    }
}
