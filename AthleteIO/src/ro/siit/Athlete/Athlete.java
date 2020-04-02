package ro.siit.Athlete;


import java.io.Serializable;
import java.util.Objects;

public class Athlete implements Serializable {

    private Integer athleteNumber;
    private String athleteName;
    private String countryCode;
    private String time;
    private String firstShootingRange;
    private String secondShootingRange;
    private String thirdShootingRange;

    public Integer getAthleteNumber() {
        return athleteNumber;
    }

    public String getTime() {
        return time;
    }

    public String getFirstShootingRange() {
        return firstShootingRange;
    }

    public String getSecondShootingRange() {
        return secondShootingRange;
    }

    public String getThirdShootingRange() {
        return thirdShootingRange;
    }

    public Athlete(Integer athleteNumber, String athleteName, String countryCode, String time, String firstShootingRange, String secondShootingRange, String thirdShootingRange) {

        if (athleteNumber == null)
            throw new IllegalArgumentException("Athlete number cannot be null");
        this.athleteNumber = athleteNumber;

        if (athleteName == null || athleteName.equals(""))
            throw new IllegalArgumentException("Athlete name cannot be null or empty");

        char[] charName = athleteName.toCharArray();
        for (char c : charName) {
            if (Character.isDigit(c))
                throw new IllegalArgumentException("Athlete name cannot contain numbers");
        }

        if (athleteName.trim().length() < 4)
            throw new IllegalArgumentException("Athlete name cannot be less than 4 letters long");

        this.athleteName = athleteName;

        if (countryCode == null || countryCode.equals(""))
            throw new IllegalArgumentException("Country Code cannot ne null/empty");
        if (countryCode.trim().length() != 2)
            throw new IllegalArgumentException("Country code has to be 2 characters long.");
        this.countryCode = countryCode;

        if (!time.matches("\\d{2}:\\d{2}"))
            throw new IllegalArgumentException("Incorrect time format");
        this.time = time;

        if (firstShootingRange.length() != 5)
            throw new IllegalArgumentException("First shooting Range must have 5 shots. ");

        this.firstShootingRange = firstShootingRange;

        if (secondShootingRange.length() != 5)
            throw new IllegalArgumentException("Second shooting Range must have 5 shots. ");
        this.secondShootingRange = secondShootingRange;

        if (thirdShootingRange.length() != 5)
            throw new IllegalArgumentException("Third shooting Range must have 5 shots. ");
        this.thirdShootingRange = thirdShootingRange;
    }


    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Athlete athlete = (Athlete) o;
        return Objects.equals(getAthleteNumber(), athlete.getAthleteNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAthleteNumber());
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "athleteNumber=" + athleteNumber +
                ", athleteName='" + athleteName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", time='" + time + '\'' +
                ", firstShootingRange='" + firstShootingRange + '\'' +
                ", secondShootingRange='" + secondShootingRange + '\'' +
                ", thirdShootingRange='" + thirdShootingRange + '\'' +
                '}';
    }

}
