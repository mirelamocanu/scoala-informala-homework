import java.util.Comparator;

public class StudentBirthDateComparator implements Comparator<Student> {
    @Override
    public int compare(Student student, Student t1) {
        return  t1.getDateOfBirth().compareTo(student.getDateOfBirth());
    }
}
