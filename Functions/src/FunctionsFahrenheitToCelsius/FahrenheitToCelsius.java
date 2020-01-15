package FunctionsFahrenheitToCelsius;

import java.util.Scanner;

public class FahrenheitToCelsius {

    public static void main(String[] args) {

        double temperature, result = 0, x = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your temperature in F degrees: ");
        temperature = sc.nextDouble();
        result = fToC(temperature, x);

        if (result > 37) {
            System.out.println("Your body temperature in Celsius degrees is " + result + ". You are ill!");
        } else {
            System.out.println("Your body temperature in Celsius degrees is " + result);
        }
    }

    public static double fToC(double temperature, double x) {
        x = (temperature - 32) * 5 / 9;
        return x;

    }
}
