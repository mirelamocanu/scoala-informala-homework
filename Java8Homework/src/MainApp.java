import java.io.IOException;


public class MainApp {
    public static void main(String[] args) throws IOException {

        try {
            start("persons.csv","outputFile.txt",5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void start(String inputFileName, String outputFileName, Integer month) throws IOException {
        PersonProcessing processFile = new PersonProcessing();
        processFile.readFromFile(inputFileName);
        processFile.filterPerson(processFile.getPersonList(),month);
        processFile.writeToFile(processFile.getNewFilteredPersonList(),outputFileName);
    }
}
