package se.hernebring.repetition3;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ovning2 {
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
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("kvitto.txt"))){
            receipt.print("Åkereds livsvarubutik", bw);
        } catch(FileNotFoundException ex){
            System.err.println("Filen existerar inte");
            System.exit(-1);
        } catch(IOException ex){
            System.err.println("Problem vid skrivning till filen.");
            System.exit(-1);
        }
    }
}
