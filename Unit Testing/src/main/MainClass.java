public class MainClass {

    public static void main(String[] args) {
        Calculator calc = new Calculator(3, null, 7);

        System.out.println("Avg :" + calc.getAvg());
        System.out.println("Min: " + calc.getMin());
        System.out.println("Max: " + calc.getMax());
        System.out.println("Sum: " + calc.getSum());
        System.out.println("Are all numbers positive? " + calc.areAllPositive());
        System.out.println("Is A even? " + calc.isAEven());

    }
}
