package FunctionsArrayAverage;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayAverage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the length of the array:");
        int x = sc.nextInt();
        int[] arr = getArray(x);
        System.out.println("Your array is: " + Arrays.toString(arr));
        int average = getArrayAverage(arr);
        System.out.println("The average of the array is: " + average);
    }

    public static int[] getArray(int x) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[x];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Please enter number for index " + i + " : ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }


    public static int getArrayAverage(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

        }
        int avg = sum / arr.length;
        return avg;
    }
}
