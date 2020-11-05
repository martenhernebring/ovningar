package se.hernebring.ovningar19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FindJava {
    public static void main(String[] args) {
        if(args == null || args.length != 2 ){
            System.err.println("Usage: FindJava directory ending");
        } else{
            String catalog = args[0];
            final String ending = args[1];
            try(Stream<Path> walk = Files.walk(Path.of(catalog))){
                walk.filter(p -> p.toString().endsWith(ending))
                    .map(Path::toAbsolutePath)
                    .map(Path::normalize)
                    .forEach(System.out::println);
            } catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}
