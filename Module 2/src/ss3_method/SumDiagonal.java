package ss3_method;

import java.util.Arrays;
import java.util.Scanner;

public class SumDiagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Nhập số hàng
        int rows;
        System.out.println("Enter the number of rows in array (integer > 0): ");
        while (true) {
            try {
                rows = Integer.parseInt(sc.nextLine());
                if (rows <= 0) {
                    System.out.println("Number of rows must be greater than 0.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid value! Please enter a valid integer.");
            }
        }
        // Nhập số cột, kiểm tra ma trận vuông
        int columns;
        System.out.println("Enter the number of columns in array (integer > 0, integer == rows): ");
        while (true) {
            try {
                columns = Integer.parseInt(sc.nextLine());
                if (columns <= 0) {
                    System.out.println("Number of columns must be greater than 0.");
                } else if (columns != rows) {
                    System.out.println("Matrix must be square! Cant caculated (Suggest enter (" + rows + ")): ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid value! Please enter a valid integer.");
            }
        }
        // Nhập phần tử của mảng
        int[][] array = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                while (true) {
                    try {
                        System.out.println("Enter the element at position [" + i + "][" + j + "]: ");
                        array[i][j] = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid value! Please enter a valid integer.");
                    }
                }
            }
        }
        System.out.println("Array is: " + Arrays.deepToString(array));

        // Gọi phương thức tính tổng
        int sumDiagonal = calculateDiagonalSum(array);
        System.out.println("Sum of diagonal elements is: " + sumDiagonal);
    }
    public static int calculateDiagonalSum(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }
        return sum;
    }
}
