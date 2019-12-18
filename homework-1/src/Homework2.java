public class Homework2 {

    public static void palindromeCheck(int num) {

        int sum = 0, temp, r;
        temp = num;
        while (num > 0) {
            r = num % 10;
            sum = (sum * 10) + r;
            num = num / 10;

        }
        if (sum == temp) {
            System.out.println("Number " + temp + " is a palindrome");
        } else {
            System.out.println("Number " + temp + " is not a palindrome");
        }
    }
}

