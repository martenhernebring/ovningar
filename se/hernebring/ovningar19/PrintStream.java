package se.hernebring.ovningar19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintStream {
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
        names.stream()
            .forEach(System.out::println);
    }
}