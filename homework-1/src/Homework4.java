public class Homework4 {

    public static void maxNum(double a, double b, double c) {
        if (a > b && a > c) {
            System.out.println("Biggest number is " + a);
        } else if (b > a && b > c) {
            System.out.println("Biggest number is " + b);
        } else if (c > a && c > b) {
            System.out.println("Biggest number is " + c);
        } else {
            System.out.println("The numbers are not distinct.");
        }
    }
}
