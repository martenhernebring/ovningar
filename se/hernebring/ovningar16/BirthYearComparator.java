package se.hernebring.ovningar16;

import java.util.Comparator;

public class BirthYearComparator implements Comparator<Person> {

    @Override
    public int compare(Person leftPerson, Person rightPerson) {
        return Integer.compare(leftPerson.getBirthYear(), rightPerson.getBirthYear());
    }
}
