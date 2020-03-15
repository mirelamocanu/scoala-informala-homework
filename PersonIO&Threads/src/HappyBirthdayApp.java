import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class HappyBirthdayApp {
    static PersonRepository repository = new PersonRepository();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Today is " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        long currentTime = System.currentTimeMillis();

        //timeWithoutThreads();
        timeWithThreads();

        long timeItTook = System.currentTimeMillis() - currentTime;
        System.out.println("Time it took to read the files: " + timeItTook);

        repository.findHappyBirthdayGirls(repository.getPersonList());

    }


    public static void timeWithoutThreads() {
        System.out.println("--------Without threads---------");
        repository.readFromFileToList("file1.txt");
        repository.readFromFileToList("file2.txt");
        System.out.println("-------------------------");

    }

    public static void timeWithThreads() throws InterruptedException {
        System.out.println("----------With threads----------");
        Runnable r1 = () -> {
            repository.readFromFileToList("file1.txt");

        };

        Runnable r2 = () -> {
            repository.readFromFileToList("file2.txt");
        };

        Runnable r3 = () -> {
            repository.readFromFileToList("file2.txt");
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("-------------------------");
    }
}



