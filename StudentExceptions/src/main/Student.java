

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class Student {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String ID;

    static Map<String, Student> studentMap = new HashMap<>();

    public Student() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.equals("")) {
            System.out.println("First name cannot be null or empty");
            throw new IllegalArgumentException("First name cannot be null or empty");
        }

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.equals("")) {
            System.out.println("Last name cannot be null or empty");
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-y");
        LocalDate dateOfBirthld = LocalDate.parse(dateOfBirth, formatter);

        LocalDate d1 = LocalDate.of(1900, 01, 01);

        if (!(dateOfBirthld.compareTo(d1) > 0) || (dateOfBirthld.compareTo(LocalDate.now().minusYears(18)) > 0)) {
            System.out.println("Incorrect date of birth.");
            throw new DateTimeException("Incorrect date of birth.");
        }

        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null || gender == "") {
            System.out.println("Gender cannot be null or empty.");
            throw new IllegalArgumentException("Gender cannot be null or empty.");
        }
        if (!((gender.equalsIgnoreCase("f")
                || gender.equalsIgnoreCase("m"))
                || gender.equalsIgnoreCase("male")
                || gender.equalsIgnoreCase("female"))) {
            System.out.println("Please choose between male, m, M or female, f, F");
            throw new IllegalArgumentException("Incorrect gender.Please choose between male, m, M or female, f, F");
        }

        this.gender = gender;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {

        if (ID == null) {
            System.out.println("ID cannot be null");
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (!ID.matches("^[0-9]*$")) {
            System.out.println("ID must contain only numbers");
            throw new IllegalArgumentException("ID must contain only numbers");
        }

        if (!(ID.trim().length() == 13)) {
            System.out.println("ID should be exactly 13 characters long");
            throw new IllegalArgumentException("ID should be exactly 13 characters long");
        }


        if (!((Integer.parseInt(ID.substring(0, 1)) == 1) || (Integer.parseInt(ID.substring(0, 1)) == 2))) {
            System.out.println("ID should start with 1 or 2");
            throw new IllegalArgumentException("ID should start with 1 or 2");
        }
        this.ID = ID;
    }

    /**
     * This method works like a constructor and sets the attributes of a Student object to the specified values.
     * Afterwards, the method adds the newly created Student object to the student HashMap created inside the Student class.
     *
     * @param firstName
     * @param lastName
     * @param dateOFBirth
     * @param gender
     * @param ID
     */
    public static void addStudent(String firstName, String lastName, String dateOFBirth, String gender, String ID) {

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDateOfBirth(dateOFBirth);
        student.setGender(gender);
        student.setID(ID);
        studentMap.put(ID, student);
    }

    /**
     * This method takes the specified ID and searches the student HashMap.
     * If the specified value is found , the Student object with the respective ID is removed from the list.
     *
     * @param ID
     */

    public static void deleteStudent(String ID) {
        if (ID == null || ID == "") {
            throw new IllegalArgumentException("ID to delete cannot be empty/null.");
        }
        if (!ID.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("ID must contain only numbers");
        }
        if (studentMap.containsKey(ID)) {
            System.out.println("Student " + ID + " " + studentMap.get(ID) + " deleted!");
            studentMap.remove(ID);

        } else {
            System.out.println("ID " + ID + " does not exist.");
            throw new IllegalArgumentException("ID does not exist.");
        }
    }

    /**
     * This method takes an int as age of student and searches through the student HashMap to find students with the required age.
     *
     * @param age
     * @return Returns a Set containing the Student objects that meet the age criteria.
     */
    public static Set<Student> getStudentWithAgeX(String age) throws NumberFormatException {
        Integer age1 = Integer.parseInt(age);
        Set<Student> studentSetWithAge = new HashSet<>();
        if (age1 < 0) {
            throw new IllegalArgumentException("Age must be positive.");
        }
        if (age1 < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18.");
        }

        for (Map.Entry s : studentMap.entrySet()) {
            studentMap.get(s);
            Student student = (Student) s.getValue();

            if (Student.getAge((student.getDateOfBirth())) == age1) {
                studentSetWithAge.add(student);
            }
        }
        System.out.println("Student list with age " + age);
        return studentSetWithAge;
    }

    /**
     * This method takes a collection , iterates through the elements and prints them.
     *
     * @param students
     */
    public static void printList(Collection<Student> students) {
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("\n");
    }

    /**
     * This method returns the
     *
     * @return
     */
    public static List<Student> printSortedListByLastName() {

        List<Student> students = new ArrayList<>();
        for (Map.Entry s : studentMap.entrySet()) {
            Student student = (Student) s.getValue();
            students.add(student);
        }
        students.sort(new StudentLastNameComparator());
        printList(students);
        return Collections.unmodifiableList(students);


    }

    public static List<Student> printSortedListByBirthDate() {

        List<Student> students = new ArrayList<>();
        for (Map.Entry s : studentMap.entrySet()) {
            Student student = (Student) s.getValue();
            students.add(student);
        }
        students.sort(new StudentBirthDateComparator());
        printList(students);
        return Collections.unmodifiableList(students);

    }


    /**
     * This method takes the date of birth and compares it to the current date.
     *
     * @param dateOfBirth
     * @return Returns the age in years.
     * @throws DateTimeParseException
     */
    public static int getAge(String dateOfBirth) throws DateTimeParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-y");
        LocalDate dateOfBirthld = LocalDate.parse(dateOfBirth, formatter);

        if (((LocalDate.now().minusYears(18)).compareTo(dateOfBirthld) > 0)) {
            Period period = Period.between(dateOfBirthld, LocalDate.now());
            return period.getYears();
        } else {
            throw new DateTimeException("Age is below 18.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getID().equals(student.getID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID());
    }

    @Override
    public String toString() {
        return "Student " +
                "First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                ", date of Birth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", ID='" + ID + '\'';
    }

}
