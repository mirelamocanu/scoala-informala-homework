import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        boolean entry = true; // boolean for returning to the beginning of the program;

        while (entry) {       // loop for returning to the beginning of the program;
            System.out.println("What would you like to do? Choose an option:");
            System.out.println("1 Sum of the first 100 numbers higher than 0");
            System.out.println("2 Palindrome check");
            System.out.println("3 Perimeter and area of the rectangle");
            System.out.println("4 Find the max number");
            System.out.println("5 Display numbers in an interval");
            System.out.println("------------------------------------------------");

            Scanner answer = new Scanner(System.in);
            int choice = answer.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Sum of the first 100 numbers higher than 0");
                    Homework1.sumNum();
                    break;
                case 2:
                    System.out.println("Palindrome check");
                    System.out.println("Please enter a number:");
                    int num = answer.nextInt();
                    Homework2.palindromeCheck(num);
                    break;
                case 3:
                    System.out.println("Perimeter and area of the rectangle");
                    System.out.println("Please enter rectangle length:");
                    double length = answer.nextDouble();

                    System.out.println("Please enter rectangle width:");
                    double width = answer.nextDouble();

                    Homework3.rectangleCalc(length, width);
                    break;
                case 4:
                    System.out.println("Find the max number");
                    System.out.println("Please enter first number:");
                    double a = answer.nextDouble();
                    System.out.println("Please enter second number:");
                    double b = answer.nextDouble();
                    System.out.println("Please enter third number:");
                    double c = answer.nextDouble();
                    Homework4.maxNum(a, b, c);
                    break;
                case 5:
                    System.out.println("Display numbers in an interval");
                    System.out.println("Please enter start number:");
                    int x = answer.nextInt();
                    System.out.println("Please enter finish number:");
                    int y = answer.nextInt();
                    Homework5.printNum(x, y);
                    break;

                default:
                    System.out.println("Invalid option. Please choose another option");

            }

            System.out.println("\n");
            System.out.println("Return to main menu? y/n");
            String reply = answer.next();
            if (reply.equals("y")) {
                entry = true;
            } else {
                entry = false;
            }
        }
    }
}


