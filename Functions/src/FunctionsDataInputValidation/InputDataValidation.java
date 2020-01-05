package FunctionsDataInputValidation;

import java.util.Scanner;

public class InputDataValidation {

    public static void main(String[] args) {
        int hour, min;
        Scanner sc = new Scanner(System.in);
        System.out.println("What time is it?");
        System.out.print("Hour ");
        hour = sc.nextInt();
        System.out.print("Minutes ");
        min = sc.nextInt();
        TimeValidation(hour, min);
    }

    private static void TimeValidation(int hour, int min) {
        if ((hour <= 24 && hour >= 0) && (0 <= min && min < 60)) {
            System.out.println("The time is: " + hour + ":" + min + " now.");
        } else {
            System.out.println("Incorrect time");

        }

    }
}
