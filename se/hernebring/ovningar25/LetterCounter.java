package se.hernebring.ovningar25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LetterCounter {
    public static void main(String[] args) throws InterruptedException {
        int threads = args.length;
        ExecutorService service = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            final String file = args[i];
            service.submit(() -> {
                    List<String> lines = new ArrayList<>();
                    try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                        
                        while(true) {
                            String line = reader.readLine();
                            if (line == null)
                                break;
                            lines.add(line);
                        }
                    } catch(IOException ex){
                        System.out.println(ex.getMessage());
                    }
                    printCount('A', lines, file);
                });
        }
        service.shutdown();
        service.awaitTermination(2, TimeUnit.MINUTES);
    }

    private static void printCount(char ch, List<String> lines, String file) {
        int counter = 0;
        for(String line: lines){
            for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) == ch){
                    counter++;
                }
            }
        }
        System.out.println(file + ": " + counter + " st " + ch);
    }
}
