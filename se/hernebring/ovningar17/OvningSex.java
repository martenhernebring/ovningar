package se.hernebring.ovningar17;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class OvningSex {
    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>();

        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.println("Skriv in ett tal (avluta med 0):");
                int number = scan.nextInt();
                if (number == 0) {
                    break;
                }
                integers.add(number);
            }
        }

        ListIterator<Integer> li = integers.listIterator(integers.size());
        while (li.hasPrevious()) {
            int number = li.previous();
            System.out.println(number);
            // just skip the next if there is one
            if (li.hasPrevious()) {
                li.previous();
            }
        }
    }
}
