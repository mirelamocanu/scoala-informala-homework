package ro.siit.Athlete;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AthleteRepository {

    private static List<Athlete> athleteList = new ArrayList<>();

    /**
     * This method reads a file, transfers the data to create objects of type Athlete and adds them to a collection of type ArrayList.
     *
     * @param fileName
     * @return a collection of type ArrayList of objects of type Athlete.
     * @throws IOException if file not found
     */

    public static List readFromFileToList(String fileName) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String s;

            while ((s = reader.readLine()) != null) {
                if ((s.length() > 0)) {
                    String[] athletesArr = s.split(",");
                    athleteList.add(new Athlete(Integer.parseInt(athletesArr[0]), athletesArr[1], athletesArr[2], athletesArr[3], athletesArr[4], athletesArr[5], athletesArr[6]));
                }
            }
            System.out.println("Following athletes were read from the file:");
            for (Athlete a : athleteList) {
                System.out.println(a);
            }
        }
        return athleteList;
    }

    /**
     * This method takes the Athlete objects stored in an ArrayList and calculates the actual time.
     * This also takes into account the penalty time calculated from the missed shots.
     *
     * @param athletesList
     */
    public static void calculateTime(List<Athlete> athletesList) {
        System.out.println("Calculated time (incl. Shooting Range misses)");
        try {
            for (Athlete a : athletesList) {
                String[] str = a.getTime().split(":");
                int timeInSeconds = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]) + getMissedShotsTime(a);
                int minutes = timeInSeconds / 60;
                int seconds = timeInSeconds % 60;
                String time = minutes + ":" + seconds;
                a.setTime(time);
            }
        } catch (NumberFormatException numEx) {
            System.out.println("Incorrect number format.");
            numEx.printStackTrace();
        }
    }

    /**
     * This method sorts the athletes arrayList and gives back the athlete with the best result
     *
     * @param athleteList
     * @return the athlete object with the best time according to Comparator rule
     */
    public static Athlete getWinnerAthlete(List<Athlete> athleteList) {
        athleteList.sort(new AthleteTimeComparator());
        int i = 0;
        while (i <= 2 && i < athleteList.size()) {
            switch (i) {
                case 0:
                    System.out.println("Winner " + athleteList.get(i));
                    break;
                case 1:
                    System.out.println("Runner-up " + athleteList.get(i));
                    break;
                case 2:
                    System.out.println("Third place " + athleteList.get(i));
            }

            i++;
        }
        return athleteList.get(0);

    }

    /**
     * This method calculates the penalty time from the missed shots.
     *
     * @param athlete object
     * @return integer of seconds corresponding to the penalty time for each Athlete.
     */
    private static int getMissedShotsTime(Athlete athlete) {
        int timeInSeconds = 0;
        String[] str1 = athlete.getFirstShootingRange().split("");
        for (String s : str1) {
            if (!(s.equals("o") || s.equals("x")))
                throw new IllegalArgumentException("Please check First shooting range in Athlete List!");
            if (s.equals("o"))
                timeInSeconds += 10;
        }
        String[] str2 = athlete.getSecondShootingRange().split("");
        for (String s : str2) {
            if (!(s.equals("o") || s.equals("x")))
                throw new IllegalArgumentException("Please check Second shooting range in Athlete list!");
            if (s.equals("o"))
                timeInSeconds += 10;
        }
        String[] str3 = athlete.getThirdShootingRange().split("");
        for (String s : str3) {
            if (!(s.equals("o") || s.equals("x")))
                throw new IllegalArgumentException("Please check Third shooting range in Athlete list!");
            if (s.equals("o"))
                timeInSeconds += 10;
        }
        return timeInSeconds;
    }

    public static List<Athlete> getAthleteList() {
        return athleteList;
    }

    private AthleteRepository() {
    }
}

