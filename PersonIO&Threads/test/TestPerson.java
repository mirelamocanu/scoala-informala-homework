
import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

public class TestPerson {


    PersonRepository testRepository = new PersonRepository();

    @Test
    public void readFromFileToList() {
        testRepository.readFromFileToList("testFile.txt");
        List<Person> testList = new ArrayList<>(testRepository.getPersonList());
        int size = testList.size();
        Assert.assertEquals(20, size);
    }


    @Test
    public void readFromFileToListFNF() {
        testRepository.readFromFileToList("Abc.txt");

    }


    @Test
    public void findHappyBirthdayGirls() {

        List<Person> testList = new ArrayList<>(testRepository.getPersonList());
        testRepository.findHappyBirthdayGirls(testList);
        List<Person> testList2 = new ArrayList<>(testRepository.getBirthdayGirls());
        int size = testList2.size();
        Assert.assertEquals(1, size);
    }


}