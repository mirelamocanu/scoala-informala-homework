package FunctionsArrayRemoveDuplicates;

import java.util.Arrays;
import java.util.Scanner;


public class ArrayDuplicateRemoval {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the length of the array:");
        int x = sc.nextInt();
        int[] arr = getArray(x);
        System.out.println("Your array is: " + Arrays.toString(arr));

        int arrNoDuplicates[] = removeDuplicates(arr);
        System.out.println("The array with no duplicates is: " + Arrays.toString(arrNoDuplicates));
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

    public static int[] removeDuplicates(int[] arr) {
        Arrays.sort(arr);
        int[] arrNoDuplicates = new int[arr.length];
        int j = 0; //Counter for the index of the arrNoDuplicates array

        for (int i = 0; i < arr.length - 1; i++) {
            int currentElement = arr[i];
            //For all elements except the last one of the arr array
            if (currentElement != arr[i + 1]) {
                arrNoDuplicates[j] = currentElement;
                j++;
            }
        }
        //For the last element of the arr array
        arrNoDuplicates[j] = arr[arr.length - 1];
        return arrNoDuplicates;
    }
}
