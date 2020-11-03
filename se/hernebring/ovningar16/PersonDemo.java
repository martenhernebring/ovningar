package se.hernebring.ovningar16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonDemo {
    public static void main(String[] args) {
        List<Person> familyList = new ArrayList<>();
        familyList.add(new Person("Malin","Hernebring",1979));
        familyList.add(new Person("Magnus","Hernebring",1981));
        familyList.add(new Person("Marten","Hernebring",1986));

        List<Person> yrgoList = new ArrayList<>();
        yrgoList.add(new Person("Marten","Hernebring",1986));
        yrgoList.add(new Person("Hampus","Ram\t",1979));
        yrgoList.add(new Person("Adrian","Book\t",1988));

        System.out.println("Före sortering programmerare");
        for(Person programmer: yrgoList){
            System.out.println(programmer);
        }
        Collections.sort(yrgoList);

        System.out.println("Efter sortering programmerare");
        for(Person programmer: yrgoList){
            System.out.println(programmer);
        }

        System.out.println("Före sortering familj");
        for(Person relative: familyList){
            System.out.println(relative);
        }
        Collections.sort(familyList);

        System.out.println("Efter sortering familj");
        for(Person relative: familyList){
            System.out.println(relative);
        }
    }
}
