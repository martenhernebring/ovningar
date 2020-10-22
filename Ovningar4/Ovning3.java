import java.util.Random;
import java.util.Scanner;

public class Ovning3 {
    public static void main(String[] args) {
        Random rand= new Random();
        int randNumber = rand.nextInt(10)+1; //1-10 nummer
        final Scanner scan = new Scanner(System.in);
        while(true){
            System.out.print("Gissa vilket tal jag tänker på? ");
            int guess = scan.nextInt();
            if(guess==randNumber) break;
            else if(guess>randNumber){
                System.out.println("Talet jag söker är mindre än "+guess+".");
            } else{
                System.out.println("Talet jag söker är större än "+guess+".");
            }
        }
        System.out.println("Hurra du lyckades!");
        scan.close();
        /*
        //slumtal från 0.0 (inklusive) och 1.0 (exklusive)
        Double randDouble = rand.nextDouble();
        int randInt = rand.nextInt();
        int randDie = rand.nextInt(6)+1; //1-6 tärning
        System.out.printf("Random numbers: %f %d %d\n",randDouble,randInt,randDie);*/
    }
}
