package se.hernebring.ovningar3;
import java.util.Scanner;
//Ett program som undersöker om ett brev har korrekta dimensioner.

public class Ovning5{
    public static void main(String[] args) {
        int length,height,width; //längd,höjd,bredd
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv in längd (i mm):");
        length = scanner.nextInt();
        if(length<140 || length>600){
            System.out.println("Brevet måste vara mellan 140-600 mm lång.");
            System.exit(0);
        }
        System.out.print("Skriv in höjd (i mm):");
        height = scanner.nextInt();
        if(height>length){
            System.out.println("Höjden måste vara mindre än längden. Gör om");
            System.exit(1);//error
        }
        if(height<90 || height>600){
            System.out.println("Höjden måste vara mellan 90-600 mm lång.");
            System.exit(0);
        }
        System.out.print("Skriv in bredd (i mm):");
        width = scanner.nextInt();
        if(width>100)
            System.out.println("Bredden får inte vara mer än 100 mm");
        else if(length+height+width>900){
            System.out.println("Summan av längden, höjden och bredden får inte överstiga 900 mm");
        }
        else System.out.println("Brevet har korrekta dimensioner.");
        scanner.close();
    }
}