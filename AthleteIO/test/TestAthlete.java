
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ro.siit.Athlete.Athlete;
import ro.siit.Athlete.AthleteRepository;
import ro.siit.Athlete.AthleteTimeComparator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TestAthlete {

    List<Athlete> athleteList = new ArrayList<>();
    Athlete mike = new Athlete(15, "Mike Bryant", "US", "29:10", "xxoxx", "xxxxx", "xxxxx");
    Athlete peter = new Athlete(20, "Peter Schmidt", "DE", "30:10", "oooxx", "xooxx", "xxooo");

    @Before
    public void setAthleteList() {
        athleteList.add(peter);
        athleteList.add(mike);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAthleteListNumberNull() {

        athleteList.add(new Athlete(null, "Mike Bryant", "US", "29:10", "xxxxx", "xxxxx", "xxxxx"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void getAthleteListNameNull() {

        athleteList.add(new Athlete(15, null, "US", "29:10", "xxxxx", "xxxxx", "xxxxx"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void getAthleteListNameContainsNumbers() {

        athleteList.add(new Athlete(15, "Mike45678Bryant", "US", "29:10", "xxxxx", "xxxxx", "xxxxx"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void getAthleteListNameLessThan4Chars() {

        athleteList.add(new Athlete(15, "Mik", "US", "29:10", "xxxxx", "xxxxx", "xxxxx"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void getAthleteListCountryCodeIsNull() {

        athleteList.add(new Athlete(15, "Mike", null, "29:10", "xxxxx", "xxxxx", "xxxxx"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void getAthleteListCountryCodeLengthNotEqual2() {

        athleteList.add(new Athlete(15, "Mike", "USA", "29:10", "xxxxx", "xxxxx", "xxxxx"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void getAthleteListTimeFormat() {

        athleteList.add(new Athlete(15, "Mike", "US", "2910", "xxxxx", "xxxxx", "xxxxx"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void getAthleteListShootingRange1Diff5() {

        athleteList.add(new Athlete(15, "Mike", "US", "29:10", "xxxx", "xxxxx", "xxxxx"));

    }


    @Test(expected = IllegalArgumentException.class)
    public void getAthleteListShootingRange2Diff5() {

        athleteList.add(new Athlete(15, "Mike", "US", "29:10", "xxxxx", "xxxx", "xxxxx"));

    }


    @Test(expected = IllegalArgumentException.class)
    public void getAthleteListShootingRange3Diff5() {

        athleteList.add(new Athlete(15, "Mike", "US", "29:10", "xxxxx", "xxxxx", "xxxx"));

    }


    @Test
    public void readFromFileToList() throws IOException {
        List<Athlete> testList = new ArrayList<>();
        testList.addAll(AthleteRepository.readFromFileToList("TestResources/AthleteResults.csv"));
        int size = testList.size();
        Assert.assertEquals(2, size);
    }


    @Test(expected = FileNotFoundException.class)
    public void readFromFileNotFound() throws IOException {

        AthleteRepository.readFromFileToList("TestResources/Abc.csv");

    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateTimeIncorrectFormat() {
        Athlete peter1 = new Athlete(20, "Peter Schmidt", "DE", "mm:ss", "oooxx", "xooxx", "xxooo");
        athleteList.add(peter1);
        AthleteRepository.calculateTime(athleteList);

    }


    @Test(expected = IllegalArgumentException.class)
    public void calculateTimeIncorrectFormatShootingRange1() {
        Athlete schmidt = new Athlete(20, "Peter Schmidt", "DE", "30:00", "11111", "xooxx", "xxooo");
        athleteList.add(schmidt);
        AthleteRepository.calculateTime(athleteList);

    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateTimeIncorrectFormatShootingRange2() {
        Athlete schmidt = new Athlete(20, "Peter Schmidt", "DE", "30:00", "xxxxx", "11111", "xxooo");
        athleteList.add(schmidt);
        AthleteRepository.calculateTime(athleteList);

    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateTimeIncorrectFormatShootingRange3() {
        Athlete schmidt = new Athlete(20, "Peter Schmidt", "DE", "30:00", "xxxxx", "xooxx", "11111");
        athleteList.add(schmidt);
        AthleteRepository.calculateTime(athleteList);

    }

    @Test
    public void calculateTime() {

        AthleteRepository.calculateTime(athleteList);
        String s = "29:20";
        Assert.assertEquals(s, mike.getTime());

    }


    @Test
    public void AthleteComparator() {
        AthleteTimeComparator comparator = new AthleteTimeComparator();
        AthleteRepository.calculateTime(athleteList);
        int v = comparator.compare(athleteList.get(0), athleteList.get(1));
        Assert.assertTrue(v > 0);
    }


    @Test
    public void getAthleteWinner() {
        AthleteRepository.calculateTime(athleteList);
        Athlete athlete = AthleteRepository.getWinnerAthlete(athleteList);
        Assert.assertSame(mike, athlete);
    }
}
