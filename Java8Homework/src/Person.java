import java.io.Serializable;
import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private String dateOfBirth;

    public Person(String firstName, String lastName, String dateOfBirth) {

        if (firstName == null || firstName.equals(""))
            throw new IllegalArgumentException("First name cannot be null or empty.");
        if (firstName.trim().length() < 3)
            throw new IllegalArgumentException("First name cannot be less than 3 letters long.");
        char[] charFirstName = firstName.toCharArray();
        for (Character c : charFirstName) {
            if (Character.isDigit(c))
                throw new IllegalArgumentException("First name cannot contain numbers.");
        }
        this.firstName = firstName;

        if (lastName == null || lastName.equals(""))
            throw new IllegalArgumentException("Last name cannot be null or empty. ");
        if (lastName.trim().length() < 3)
            throw new IllegalArgumentException("Last name cannot be less than 3 letters long");
        char[] charLastName = lastName.toCharArray();
        for (Character c : charLastName) {
            if (Character.isDigit(c))
                throw new IllegalArgumentException("Last name cannot contain numbers");
        }
        this.lastName = lastName;


        if (!(dateOfBirth.matches( "^\\d{4}-\\d{2}-\\d{2}$")))
            throw new IllegalArgumentException("Incorrect date of birth format.");
        String []stringBDay=dateOfBirth.split("-");
        if (!(stringBDay[0].matches("(19|20)[0-9]{2}" )))
            throw new IllegalArgumentException("Year must be between 1900-2099.");
        if (!(stringBDay[1].matches("0[1-9]|1[012]" )))
            throw new IllegalArgumentException("Month must be between 1-12.");
        if (!(stringBDay[2].matches("0[1-9]|[12][0-9]|3[01]" )))
            throw new IllegalArgumentException("Day of month must be between 1-31.");

        this.dateOfBirth = dateOfBirth;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getLastName(), person.getLastName()) &&
                Objects.equals(getDateOfBirth(), person.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getDateOfBirth());
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
