package se.hernebring.ovningar23;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleFloatPrintSwedish {
    public static void main(String[] args) {
        Locale locale = new Locale("sv","SE");
        ResourceBundle bundle = ResourceBundle.getBundle("resources/translations", locale);
        System.out.printf(bundle.getString("enter3floats"));
        double[] floatInput = new double[3];
        try(Scanner scan = new Scanner(System.in)){
            scan.useLocale(locale);
            for(int i = 0; i < floatInput.length; i++){
                floatInput[i] = scan.nextDouble();
                scan.nextLine();
            }
        }
        double sum = 0;
        for(double floatNumber : floatInput){
            sum+= floatNumber/floatInput.length;
        }
        System.out.printf(locale, bundle.getString("sum"), sum);
    }
}
