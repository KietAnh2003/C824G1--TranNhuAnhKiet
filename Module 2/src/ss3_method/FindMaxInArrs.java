package ss3_method;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxInArrs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows;
        System.out.println("Enter the number of rows in array (number is integer and greater than 0): ");
        while (true) {
            try {
                rows = Integer.parseInt(sc.nextLine());
                if (rows <= 0) {
                    System.out.println("Number of rows must be greater than 0.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid value! Please enter a valid number.");
            }
        }

        int columns;
        System.out.println("Enter the number of columns in array (greater than 0): ");
        while (true) {
            try {
                columns = Integer.parseInt(sc.nextLine());
                if (columns <= 0) {
                    System.out.println("Number of columns must be greater than 0.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid value! Please enter a valid number.");
            }
        }

        int[][] arr = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                while (true) {
                    try {
                        System.out.println("Enter the element at position [" + i + "][" + j + "]: ");
                        arr[i][j] = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid value! Please enter a valid integer.");
                    }
                }
            }
        }

        int max = arr[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println("Array is: " + Arrays.deepToString(arr));
        System.out.println("Max number in array is: " + max);
    }
}
