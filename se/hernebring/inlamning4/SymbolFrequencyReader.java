package se.hernebring.inlamning4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class SymbolFrequencyReader {

    public static void main(String[] args) {

        final Collection<String> books = readFiles(args);

        final var symbolCounter = new SymbolFrequencyTable(books);

        System.out.println(symbolCounter);
    }

    static void printFrequencyTable(Map<Character, Integer> table) {
        for (Map.Entry<Character, Integer> entry : table.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    static Collection<String> readFiles(String[] fileNames) {
        Collection<String> textFiles = new ArrayList<>();
        for (String fileName : fileNames) {
            textFiles.add(fileName);
        }
        return textFiles;
    }
}
