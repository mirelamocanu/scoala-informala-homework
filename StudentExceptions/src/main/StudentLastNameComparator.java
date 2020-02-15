import java.util.Comparator;

public class StudentLastNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student student, Student t1) {
        return student.getLastName().compareTo(t1.getLastName());
    }
}
