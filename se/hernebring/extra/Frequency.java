package se.hernebring.extra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Frequency {
    private Map<Character, Integer> table;
    private boolean caseMatters;

    public Frequency(){
        this(true);
    }

	public Frequency(boolean caseMatters) {
        table = new TreeMap<>();
        this.caseMatters = caseMatters;
    }

    public void count(Path path) {
            if(Files.exists(path)){
                try (Stream<String> fileStream = Files.lines(path)) {
                    count(fileStream);
                } catch (IOException ex) {
                    System.err.println("Problems opening file " + path + ".");
                }
            } else{
                System.err.println("File " + path + " does not exist.");
            }
    }
    
    public void count(Stream<String> fileStream) {
        fileStream.forEach(line -> {
            for (char ch : line.toCharArray()) {
                count(ch);
            }
        });
    }

    private void count(char ch) {
        if(!Character.isWhitespace(ch)){
            if(!caseMatters){
                ch = Character.toLowerCase(ch);
            }
            Integer freq = table.get(ch);
            if (freq == null) {
                table.put(ch, 1);
            } else {
                table.put(ch, freq + 1);
            }
        }
    }

    public void print() {
        table.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }

    public static void main(String[] args) {
        if(args == null || args.length == 0){
            System.err.println("Usage: java Frequency [file.txt] ... or " +
                "java Frequency [file.txt] -i [file.txt]... ");
                System.exit(-1);
        } else{
            printCharacterFrequency(args);
        }
    }

    private static void printCharacterFrequency(String[] args) {
        List<String> files = new ArrayList<>(Arrays.asList(args));
        Frequency table = null;
        if(files.get(0).equals("-i")){
            table = new Frequency(false);
            files.remove(0);
        } else{
            table = new Frequency();
        }
        for (String file : files) {
            table.count(Path.of(file));
        }
        table.print();
    }
    
}
