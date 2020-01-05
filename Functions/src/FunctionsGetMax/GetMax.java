package FunctionsGetMax;

import java.util.Scanner;

public class GetMax {

    public static void main(String[] args) {

        int x, y, z, a, b;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter first number:");
        x = sc.nextInt();
        System.out.print("Please enter second number:");
        y = sc.nextInt();
        System.out.print("Please enter third number:");
        z = sc.nextInt();
        a = getMax(x, y);
        b = getMax(x, z);
        System.out.println("Max number is: " + getMax(a, b));

    }

    public static int getMax(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }
}
