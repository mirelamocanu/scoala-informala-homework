import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestGetPersonHobby {

    Person p1 = new Person("34561", "Paula", 32, "0723421501");
    Person p2 = new Person("3454471", "Andreea", 22, "072123501");

    Country ro = new Country("Romania", "40");
    Address addressRo = new Address("Brasov", ro);
    List<Address> hobbyAddress = new ArrayList();

    Hobby badminton = new Hobby("Badminton", 5, hobbyAddress);
    List<Hobby> hobby = new ArrayList();

    Map<Person, List<Hobby>> personHobby = new HashMap<>();
    List testList = new ArrayList();

    @Test

    public void getPersonHobbyNotNull() {
        hobbyAddress.add(addressRo);
        hobby.add(badminton);
        personHobby.put(p1, hobby);
        testList = PersonHobbyApp.getPersonHobby(personHobby, p1);
        Assert.assertNotNull(testList);
    }

    @Test
    public void getPersonHobbyWithNull() {
        hobbyAddress.add(addressRo);
        hobby.add(badminton);
        testList = PersonHobbyApp.getPersonHobby(personHobby, p2);
        Assert.assertNull(testList);
    }
}
