package se.hernebring.ovningar16;

import java.util.HashSet;
import java.util.Set;

public class PersonHashDemo {
    public static void main(String[] args) {
        Person[] persons = new Person[10];
        persons[0] = new Person("Abiha", "Swift", 1929);
        persons[1] = new Person("Alyce", "Benton", 1943);
        persons[2] = new Person("Sydney", "Walton", 1944);
        persons[3] = new Person("Ayah", "Bird", 1957);
        persons[4] = new Person("Sumaiyah", "Hagan", 1985);
        persons[5] = new Person("Roseanna", "Yates", 1991);
        persons[6] = new Person("Rabia", "Keenan", 1993);
        persons[7] = new Person("Rose", "Shepherd", 1998);
        persons[8] = new Person("Nylah", "Kline", 2005);
        persons[9] = new Person("Lesley", "Read", 2005);

        Set<Integer> hashSet = new HashSet<>();
        int size = 0;
        for (Person person : persons) {
            int hash = person.hashCode();
            hashSet.add(hash);
            System.out.println(hash);
        }
        size = hashSet.size();
        System.out.println(size);
        
        Person[] personsCopy = new Person[10];
        personsCopy[0] = new Person(persons[0]);
        personsCopy[1] = new Person(persons[1]);
        personsCopy[2] = new Person(persons[2]);
        personsCopy[3] = new Person(persons[3]);
        personsCopy[4] = new Person(persons[4]);
        personsCopy[5] = new Person(persons[5]);
        personsCopy[6] = new Person(persons[6]);
        personsCopy[7] = new Person(persons[7]);
        personsCopy[8] = new Person(persons[8]);
        personsCopy[9] = new Person(persons[9]);
        
        for(int i = 0; i< persons.length; i++) {
            if(persons[i] == personsCopy[i]) {
                System.out.println("Same reference");
            }
            if(persons[i].equals(personsCopy[i])) {
                System.out.println("Same person");
            }
        }
    }
}
