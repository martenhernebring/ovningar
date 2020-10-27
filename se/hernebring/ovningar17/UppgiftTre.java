package se.hernebring.ovningar17;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class UppgiftTre {
    public static void main(String[] args) {
        Collection<String> gamblers = new ArrayList<>();
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
        int winner = ThreadLocalRandom.current().nextInt(gamblers.size());
        int i = 0;
        for (String gambler : gamblers) {
            if (i == winner) {

                System.out.printf("And the winner is: %s !!!", gambler);
                break;
            } else {
                i++;
            }
        }
    }
}