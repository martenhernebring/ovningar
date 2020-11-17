package se.hernebring.ovningar23;

import java.text.DateFormatSymbols;
import java.util.Locale;

public class LocaleDatePrinter {
    public static void main(String[] args) {
        System.out.println("Print all months in Swedish and Swiss.");
        Locale swe = new Locale("sv","SE");
        Locale sch = new Locale("de","CH"); 
        String[] sweMonths = DateFormatSymbols.getInstance(swe).getMonths();
        for(String month: sweMonths){
            System.out.println(month);
        }
        String[] schMonths = DateFormatSymbols.getInstance(sch).getMonths();
        for(String month: schMonths){
            System.out.println(month);
        }
    }
}
