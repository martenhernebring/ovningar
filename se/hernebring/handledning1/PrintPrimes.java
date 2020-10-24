package se.hernebring.handledning1;
import java.util.Scanner;

public class PrintPrimes {

    private static boolean isPrime(int number){
        for(int i=2;i<=number/2;i++){
            if(number%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        int numberOfPrimes=0;
        do{
            System.out.println("Hur många primtal vill du se?");
            if(scan.hasNextInt())
                numberOfPrimes=scan.nextInt();
            else
                scan.nextLine();
        } while (numberOfPrimes<1);
        int lastPrime=1;
        System.out.println("Dina primtal:");
        for(int i=0;i<numberOfPrimes;i++){
            do{
                if(isPrime(++lastPrime)){
                    System.out.println(lastPrime);
                    break;
                }
            } while(true);
        }
        scan.close();
    }
}