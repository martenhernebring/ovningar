package se.hernebring.ovningar4;
import java.util.Random;
import java.util.Scanner;

public class Ovning7 {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        int win=0,lose=0;
        Random rand= new Random();
        while(true){
            int opponent = rand.nextInt(3)+1; //1-3 nummer
            System.out.println("Vilket är ditt drag? (sten/sax/påse/sluta)");
            String val = scan.next();
            val.toLowerCase();
            if(val.equals("sluta")){
                break;
            } else if(val.equals("sten")){
                if(opponent==2){
                    System.out.println("Datorn valde sax. Du vann");
                    win++;
                } else if(opponent==3){
                    System.out.println("Datorn valde påse. Datorn vann");
                    lose++;
                }
            } else if(val.equals("sax")){
                if(opponent==3){
                    System.out.println("Datorn valde påse. Du vann");
                    win++;
                } else if(opponent==1){
                    System.out.println("Datorn valde sten. Datorn vann");
                    lose++;
                }
            } else if(val.equals("påse")){
                if(opponent==1){
                    System.out.println("Datorn valde sten. Du vann");
                    win++;
                } else if(opponent==2){
                    System.out.println("Datorn valde sax. Datorn vann");
                    lose++;
                }
            }
        }
        scan.close();
        System.out.println("Du vann "+win+" match(er), datorn vann "+lose+" match(er).");
    }
}
