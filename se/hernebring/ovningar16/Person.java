package se.hernebring.ovningar16;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int birthYear;

    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }
    
    public Person(Person person) {
        firstName = person.firstName;
        lastName = person.lastName;
        birthYear = person.birthYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public int compareTo(Person person) {
        return lastName.compareTo(person.lastName);
    }

    @Override
    public String toString() {
        return String.format("First name:%s,\tLast name: %s\tBirth year:%s", firstName, lastName, birthYear);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        return Objects.equals(firstName, person.getFirstName()) && Objects.equals(lastName, person.getLastName())
                && Objects.equals(birthYear, person.getBirthYear());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + birthYear;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return super.hashCode();
    }
}