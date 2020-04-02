package ro.siit.Athlete;

import java.util.Comparator;

public class AthleteTimeComparator implements Comparator<Athlete> {


    @Override
    public int compare(Athlete athlete, Athlete t1) {
        return athlete.getTime().compareTo(t1.getTime());
    }
}
