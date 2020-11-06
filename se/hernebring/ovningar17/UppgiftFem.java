package se.hernebring.ovningar17;

//import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UppgiftFem {
    public static void main(String[] args) {
        //Set<String> names = new HashSet<>();
        Set<String> names = new TreeSet<>();
        try(Scanner scan = new Scanner(System.in)){
            while (true) {
                System.out.println("Skriv in ett namn. Avsluta med enter.");
                String name = (scan.nextLine());
                if(name.isBlank()){
                    break;
                } else{
                    names.add(name);
                }
            }
        }
        for(String name: names){
            System.out.println(name);
        }
    }
}
