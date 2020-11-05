package se.hernebring.inlamning3;

import java.util.Scanner;

/**A simple program to simulate collecting coins in a Piggy Bank 
 * @author Mårten Hernebring @version 5
*/
public class User {

    //internal method for collecting coins in a Piggy Bank
    private static void collectCoins(Piggy bank) {
        //Using Swedish input shell
        final Scanner shell = new Scanner(System.in, "Cp850");
        Boolean saved = false; //private instance that is true if last value was saved, null for zero
        do { //loop until user enters 0
            System.out.println("Vilket mynt vill du spara?");
            saved = bank.save(shell.nextInt());
        } while (saved != null);
        shell.close();
    }

    /**main method creating a Piggy Bank for the User that collect coins and read them */
    public static void main(String[] args) {
        final Piggy bank = new Piggy();
        collectCoins(bank);
        System.out.println("Du har sparat " + bank.getCoins() + 
            " mynt till ett totalt värde av " + bank.getSavings() + " kronor.");
    }
}
