package se.hernebring.ovningar17;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UppgiftTva {
    public static void main(String[] args) {
        List<String> gamblers = new ArrayList<>();
        System.out.println("Skriv in alla personer som deltar i tävlingen. Avsluta med enter.");
        String input;

        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                input = scanner.nextLine();
                if (input.isEmpty()) {
                    break;
                } else {
                    gamblers.add(input);
                }
            }
        }

        Collections.shuffle(gamblers);
        System.out.println(gamblers.get(0));

    }
}