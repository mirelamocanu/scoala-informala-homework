import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PersonProcessing {
    private static List<Person> personList;
    private static List<Person> newFilteredPersonList;

    /**
     * This method reads a file, parses its content, instantiates Person objects and adds them to a list.
     * @param filename
     * @return a list of Person class objects.
     * @throws IOException
     */
    public List<Person> readFromFile(String filename) throws IOException {
        personList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String s;
            while ((s = reader.readLine()) != null) {
                if (s.length() > 0) {
                    String[] personString = s.split(",");
                    personList.add(new Person(personString[0], personString[1], personString[2]));
                }
            }
            return personList;
        }
    }


    /**
     * This method uses streams to filter the given list and updates a new list with only the Person objects
     * whose birthday matches the month given as a parameter.
     * @param personList
     * @param month
     * @return a list of Person objects wich match the month criteria
     */

    public List<Person> filterPerson(List<Person> personList, Integer month) {
        personList.sort(Comparator.comparing(Person::getLastName));
        List<List<Person>> personStream = Arrays.asList(personList);

        newFilteredPersonList = personStream
                .stream()
                .flatMap(Collection::stream)
                .filter(p -> {
                    String[] strings = p.getDateOfBirth().split("-");
                    LocalDate birthdateLD = LocalDate.of(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2]));
                    return birthdateLD.getMonthValue() == month;
                })
                .collect(Collectors.toList());
       return newFilteredPersonList;
    }


    /**
     *  This method prints the given list to a file.
     * @param newFilteredPersonList
     * @param outputFilename
     * @throws IOException
     */
    public void writeToFile(List <Person>newFilteredPersonList,String outputFilename) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(outputFilename))) {

            for (Person p : newFilteredPersonList) {
                out.write(p.getFirstName() + "," + p.getLastName() + "," + p.getDateOfBirth());
                out.newLine();
                out.flush();
            }
        }
    }


    public List<Person> getNewFilteredPersonList() {
        return newFilteredPersonList;
    }

    public List<Person> getPersonList() {
        return personList;
    }
}


