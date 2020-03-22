
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestForPersonProcessing {
    List<Person> testList = new ArrayList<>();
    PersonProcessing processFile = new PersonProcessing();


    @Test

    public void testReadFromFile() throws IOException {
        processFile.readFromFile("personsForTest.csv");
        int v = processFile.getPersonList().size();
        Assert.assertEquals(5, v);
    }

    @Test(expected = FileNotFoundException.class)
    public void testReadFromFileFNF() throws IOException {
        processFile.readFromFile("ABC.csv");
        int v = processFile.getPersonList().size();
        Assert.assertEquals(4, v);
    }

    @Test
    public void testFilterPerson() throws IOException {
        processFile.readFromFile("personsForTest.csv");
        processFile.filterPerson(processFile.getPersonList(), 3);
        int v = processFile.getNewFilteredPersonList().size();
        Assert.assertEquals(2, v);
        Person elenaMatei = new Person("Elena", "Matei", "1999-03-10");
        Assert.assertEquals(processFile.getNewFilteredPersonList().get(1), elenaMatei);

    }

    @Test
    public void testWriteToFile() throws IOException {
        processFile.readFromFile("personsForTest.csv");
        processFile.filterPerson(processFile.getPersonList(), 3);
        processFile.writeToFile(processFile.getNewFilteredPersonList(), "test.txt");
        processFile.readFromFile("test.txt");
        int v = processFile.getPersonList().size();
        Assert.assertEquals(2, v);
    }

    @Test
    public void testAddPersonToList() {
        testList.add(new Person("Ana", "Ion", "2000-10-15"));
        int v = testList.size();
        Assert.assertEquals(1, v);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPersonToListFirstNameNull() {
        testList.add(new Person(null, "Ion", "2000-10-15"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPersonToListFirstNameLess3() {
        testList.add(new Person("a  ", "Ion", "2000-10-15"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPersonToListFirstNameNumbers() {
        testList.add(new Person("A345", "Ion", "2000-10-15"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPersonToListLastNameNull() {
        testList.add(new Person("Ana", null, "2000-10-15"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPersonToListLastNameLess3() {
        testList.add(new Person("Ana", "u   ", "2000-10-15"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPersonToListLastNameNumbers() {
        testList.add(new Person("Ana", "I345", "2000-10-15"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPersonToListBirthDateIncorrectFormat() {
        testList.add(new Person("Ana", "Ion", "20-10-15"));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddPersonToListBirthDateIncorrectYear() {
        testList.add(new Person("Ana", "Ion", "1899-10-15"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPersonToListBirthDateIncorrectMonth() {
        testList.add(new Person("Ana", "Ion", "2000-18-15"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPersonToListBirthDateIncorrectDay() {
        testList.add(new Person("Ana", "Ion", "2000-10-60"));
    }


}
