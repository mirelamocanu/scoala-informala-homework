import java.text.ParseException;
import java.util.Map;


public class StudentApp {

    public static void main(String[] args) {

        Student.addStudent("Daniela", "Mocanu", "02-07-2001", "F", "2222222222222");
        Student.addStudent("Irina", "Anton", "22-01-2002", "female", "2444444444444");
        Student.addStudent("Andrei", "Petrescu", "15-09-2000", "male", "1111111111111");
        Student.addStudent("Bogdan", "Ionescu", "25-10-1995", "m", "1333333333333");


        for (Map.Entry x : Student.studentMap.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }

        // Student.deleteStudent(null);


        System.out.println(Student.getAge("12-10-2006"));

        try {
            Student.printList(Student.getStudentWithAgeX("15"));
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.out.println("Age must be a number!");
        }

        Student.printSortedListByLastName();

        Student.printSortedListByBirthDate();


    }
}
