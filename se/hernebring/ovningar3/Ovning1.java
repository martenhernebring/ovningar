package se.hernebring.ovningar3;
import java.util.Scanner;
//Ett program som ber användaren att mata bredd och höjd på en rektangel.
//Programmet skriver då ut omkrets och area med två decimaler.

public class Ovning1{
    public static void main(String[] args) {
        double height, width, area, circumference; //bredd och höjd på rektangeln, area, omkrets
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv höjden på rektangeln");
        height = scanner.nextDouble();
        System.out.println("Skriv bredden på rektangeln");
        width = scanner.nextDouble();
        area = height*width;
        circumference = 2*height+2*width;
        //System.out.println("Rektangelns omkrets är "+circumference+" och area är "+area);//,circumference,area
        System.out.printf("Rektangelns omkrets är %.2f. och area är %.2f.\n", circumference,area);
        if(area>1000)
            System.out.println("Rektangeln är jättestor!");
        scanner.close();
    }
}