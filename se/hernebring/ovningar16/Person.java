package se.hernebring.ovningar16;
public class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;
    private int birthYear;

    public Person(String firstName, String lastName, int birthYear){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
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
        return String.format("First name:%s,\tLast name: %s\tBirth year:%s"
            ,firstName,lastName,birthYear);
    }
}