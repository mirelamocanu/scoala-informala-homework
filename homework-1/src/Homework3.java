public class Homework3 {

    public static void rectangleCalc(double length, double width) {
        double Perimeter = 0, Area = 0;
        if (length <= 0 || width <= 0) {
            System.out.println("Negative numbers or 0 not accepted! Please try again!");
            return;
        } else {
            Perimeter = 2 * (length + width);
            Area = length * width;
        }
        System.out.println("Perimeter is : " + Perimeter);
        System.out.println("Area is : " + Area);
    }
}

