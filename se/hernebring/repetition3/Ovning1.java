package se.hernebring.repetition3;

import java.util.Scanner;

public class Ovning1 {
    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        try(Scanner scan = new Scanner(System.in)){
            while(true){
                System.out.print("Skriv varunamn (enter för avsluta): ");
                String ware = scan.nextLine();
                if(ware.isEmpty()){
                    break;
                }
                System.out.print("Skriv örespris: ");
                long cents = scan.nextLong();
                receipt.addWare(ware, cents);
                scan.nextLine();
            }    
        }
        System.out.println();
        receipt.print("Åkereds livsvarubutik");
    }
}
