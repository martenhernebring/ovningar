package se.hernebring.ovningar16;

import java.time.LocalDate;
import java.util.Objects;

public class BirthdayPerson implements Comparable<BirthdayPerson> {
    private String firstName;
    private Integer dayOfYear;

    public BirthdayPerson(String firstName, LocalDate birthDay) {
        this.firstName = firstName;
        this.dayOfYear = birthDay.getDayOfYear();
    }
    
    public BirthdayPerson(BirthdayPerson person) {
        firstName = person.firstName;
        dayOfYear = person.dayOfYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getDayOfYear() {
        return dayOfYear;
    }

    @Override
    public String toString() {
        return String.format("First name:%s,\tDay of year:%s", firstName, dayOfYear);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BirthdayPerson)) {
            return false;
        }
        BirthdayPerson person = (BirthdayPerson) obj;
        return Objects.equals(firstName, person.getFirstName())
                && Objects.equals(dayOfYear, person.getDayOfYear());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dayOfYear == null) ? 0 : dayOfYear.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        return super.hashCode();
    }

    @Override
    public int compareTo(BirthdayPerson person) {
        return getDayOfYear().compareTo(person.getDayOfYear());
    }

}