import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.DateTimeException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class TestStudent {

    @Before
    public void setStudent() {
        Student.addStudent("Daniela", "Mocanu", "02-07-2001", "F", "2222222222222");
        Student.addStudent("Andrei", "Petrescu", "15-09-2000", "male", "1111111111111");
        Student.addStudent("Bogdan", "Ionescu", "25-10-1995", "m", "1333333333333");
        Student.addStudent("Irina", "Anton", "22-01-2002", "f", "2444444444444");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWithFirstNameNull() {

        Student.addStudent("", "FRDF", "19-02-2000", "f", "1234567891012");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWithLastNameNull() {
        Student.addStudent("EDRFT", "", "19-02-2000", "f", "1234567891012");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWithIncorrectGender() {
        Student.addStudent("tyuiih", "FRDF", "19-02-2000", "gtrgk", "1234567891012");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWithNullGender() {
        Student.addStudent("tyuiih", "FRDF", "19-02-2000", null, "1234567891012");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWithEmptyGender() {
        Student.addStudent("tyuiih", "FRDF", "19-02-2000", "", "1234567891012");
    }

    @Test(expected = DateTimeException.class)
    public void addStudentWithBirthDateBefore1900() {
        Student.addStudent("EDRFT", "gftt", "21-01-1899", "f", "1234567891012");
    }

    @Test(expected = DateTimeException.class)
    public void addStudentWithBirthDateAfter2002() {
        Student.addStudent("EDRFT", "gftt", "21-01-2003", "f", "1234567891012");
    }

    @Test(expected = DateTimeParseException.class)
    public void addStudentWithBirthDateNull() {
        Student.addStudent("EDRFT", "gftt", "", "f", "1234567891012");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWithIncorrectIDNumbers() {

        Student.addStudent("ghjkl", "FRDF", "19-02-2000", "f", "5234567891012");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWithIncorrectIDLetters() {
        Student.addStudent("ghjkl", "FRDF", "19-02-2000", "f", "sdfgyyuik");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWithNullID() {
        Student.addStudent("ghjkl", "FRDF", "19-02-2000", "f", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentWithEmptyID() {
        Student.addStudent("ghjkl", "FRDF", "19-02-2000", "f", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteStudentWithNull() {
        Student.deleteStudent(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteStudentWithNoNumbersID() {
        Student.deleteStudent("asdhytr");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteStudentWithInexistentID() {
        Student.deleteStudent("2222220000000");
    }

    @Test
    public void deleteStudentWithExistentID() {
        Student.deleteStudent("2222222222222");
    }

    @Test
    public void getStudentWithAgeX() {
        Student.getStudentWithAgeX("19");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStudentWithAgeXNegativeValue() {
        Student.getStudentWithAgeX("-1");
    }

    @Test(expected = NumberFormatException.class)
    public void getStudentWithAgeXNotNumber() {
        Student.getStudentWithAgeX("fgbhn");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStudentWithAgeLess18() {
        Student.getStudentWithAgeX("15");
    }

    @Test(expected = DateTimeException.class)
    public void getAgeLess18() {
        Student.getAge("15-05-2006");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStudentWithAgeXNull() {
        Student.getStudentWithAgeX(null);
    }

    @Test
    public void ComparatorByLastName() {

        StudentLastNameComparator comparator = new StudentLastNameComparator();
        List<Student> studentList = new ArrayList<>();
        for (Map.Entry s : Student.studentMap.entrySet()) {
            Student student = (Student) s.getValue();
            studentList.add(student);
        }
        System.out.println(studentList.get(0).getLastName());
        System.out.println(studentList.get(3).getLastName());
        int v = comparator.compare(studentList.get(0), studentList.get(3));
        Assert.assertTrue(v > 0);
    }

    @Test
    public void ComparatorByBirthDate() {

        StudentBirthDateComparator comparator = new StudentBirthDateComparator();
        List<Student> studentList = new ArrayList<>();
        for (Map.Entry s : Student.studentMap.entrySet()) {
            Student student = (Student) s.getValue();
            studentList.add(student);
        }

        System.out.println(studentList.get(0).getDateOfBirth());
        System.out.println(studentList.get(3).getDateOfBirth());
        int v = comparator.compare(studentList.get(0), studentList.get(3));
        Assert.assertTrue(v < 0);
    }


}


