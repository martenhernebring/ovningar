package se.hernebring.inlamning4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.hernebring.log.Slf4j2Demo;

public class SymbolFrequencyReader {

    final static Logger logger = LoggerFactory.getLogger(Slf4j2Demo.class);

    public static void main(String[] args) {

        final Collection<String> books = readFiles(args);

        final var symbolCounter = new SymbolCounter(books);

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
