package ss1_ss11.ss1_java.ss3_method;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinInArr {
    public static void main(String[] args) {
        int[] arr = new int[8];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements into an array of size 8!");
        for (int i = 0; i < arr.length; i++) {
            while (true) {
                System.out.print("Enter element " + (i + 1) + ": ");
                try {
                    arr[i] = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Error! Please enter a valid integer.");
                    sc.nextLine();
                }
            }
        }
        System.out.println("Array is: " + Arrays.toString(arr));
        minArr(arr);
    }
    public static void minArr(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println("Min number in array is: " + min);
    }
}
