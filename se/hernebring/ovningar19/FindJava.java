package se.hernebring.ovningar19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FindJava {
    public static void main(String[] args) {
        if(args == null || args.length != 1 ){
            System.err.println("Usage: FindJava directory");
        } else{
            String catalog = args[0];
            try(Stream<Path> walk = Files.walk(Paths.get(catalog))){
                walk.filter(p -> p.toString()
                    .endsWith(".java"))
                    .forEach(System.out::println);
            } catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}
