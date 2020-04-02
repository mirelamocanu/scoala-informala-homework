import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonRepository {

    private static List<Person> personList = new ArrayList<>();
    private static List<Person> birthdayGirls = new ArrayList<>();

    /**
     * This method reads a file, parses its content, instantiates Person objects and adds them to a list.
     *
     * @param filename
     */
    public void readFromFileToList(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String s;
            while ((s = reader.readLine()) != null) {
                if ((s.length() > 0)) {
                    String[] stringReader = s.split(",");
                    Person p = new Person((stringReader[0]), stringReader[1]);
                    p.setGender(stringReader[2]);
                    addPerson(p);
                }
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("File " + filename + " could not be found!");
            fnf.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method searches the list given in parameter for female persons born today, prints a console message wishing them a happy birthday
     * and adds these persons to a birthday list.
     * It also calls the method for writing the console output to a different file .
     *
     * @param personList
     */

    public void findHappyBirthdayGirls(List<Person> personList) {

        for (Person p : personList) {
            String[] birthday = p.getBirthDate().split("-");
            LocalDate personBirthday = LocalDate.of(Integer.parseInt(birthday[0]), Integer.parseInt(birthday[1]), Integer.parseInt(birthday[2]));

            if ((personBirthday.getMonth().equals(LocalDate.now().getMonth())) &&
                    (personBirthday.getDayOfMonth() == LocalDate.now().getDayOfMonth())) {
                if (p.getGender().equals(PersonGender.FEMALE))
                    System.out.println("Happy Birthday, " + p.getFirstName() + "(" + birthday[0] + ")!");
                birthdayGirls.add(p);
                writeToFile();
            }
        }
    }

    /**
     * This method searches the lit with birthdays and writes the "Happy Birthday! + name" message to a file.
     */
    private void writeToFile() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("ConsoleOutput.txt"))) {
            for (Person p : birthdayGirls) {
                String[] birthday = p.getBirthDate().split("-");
                out.write("Happy Birthday, " + p.getFirstName() + "(" + birthday[0] + ")!");
                out.newLine();
                out.flush();
            }
        } catch (IOException e) {
            System.out.println("Error during writing");
            e.printStackTrace();
        }

    }

    /**
     * This method adds a person to a list.
     * Method is synchronized, so the list cannot be accessed by more than on thread at a time.
     * @param person
     */
    private synchronized void addPerson(Person person) {
        personList.add(person);
    }

    public PersonRepository() {

    }

    public List<Person> getPersonList() {
        return Collections.unmodifiableList(personList);
    }

    public List<Person> getBirthdayGirls() {
        return Collections.unmodifiableList(birthdayGirls);
    }
}
