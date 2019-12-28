public class Homework5 {

    public static void printNum(int x, int y) {
        if (x < y) {
            System.out.print("The numbers between " + x + " and " + y + " are: ");
            for (int i = x; i <= y; i++) {
                System.out.print(i + " ");
            }
        } else {
            int temp = x;
            x = y;
            y = temp;
            System.out.print("The numbers between " + x + " and " + y + " are: ");
            for (int i = x; i <= y; i++) {
                System.out.print(i + " ");

            }
        }
    }
}
