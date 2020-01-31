import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAgeComparator {

    Person p1 = new Person("12345", "Elena", 29, "0774678932");
    Person p2 = new Person("54321", "Luiza", 35, "0733221144");
    Person p3 = new Person("542321", "Dan", 35, "0734441144");


    @Test
    public void testAgeComparatorWithSameAge() {
        PersonAgeComparator comparator = new PersonAgeComparator();
        int v = comparator.compare(p3, p2);
        Assert.assertEquals(0, v);


    }
    @Test
    public void testAgeComparator() {
        PersonAgeComparator comparator = new PersonAgeComparator();
        int v = comparator.compare(p1, p2);
        Assert.assertEquals(-1, v);


    }


}
