package se.hernebring.repetition1;
import java.util.Scanner;

public class Ovning2 {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        System.out.println("Skriv ett tal:");
        int number1 = scan.nextInt();
        System.out.println("Skriv ett till tal:");
        int number2 = scan.nextInt();
        if(number1>number2){
            int temp= number1;
            number1=number2;
            number2=temp;
        } 
        if(number1%2==1||number1%2==-1)
            number1++;

        for(int i=number1;i<=number2;i+=2){
            System.out.println(i);
        }
        scan.close();
    }
}
