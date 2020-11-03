package se.hernebring.ovningar19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PrintStreamTrimLowcaseMinsizeCollect {
    public static void main(String[] args) {
        System.out.println("Skriv in namn (avsluta med enter).");
        List<String> names = new ArrayList<>();
        String input = null;
        try(Scanner scan = new Scanner(System.in)){
            do{
                input = scan.nextLine();
                names.add(input);
            } while (!input.trim().isEmpty());
        }
        names = names.stream()
            .map(s -> s.replaceAll("\\s+", ""))
            .filter(s -> s.length() > 1)
            .map(String::toLowerCase)
            .collect(Collectors.toList());
        for(String name : names){
            System.out.print(name+" ");
        }
        System.out.println();
    }
}