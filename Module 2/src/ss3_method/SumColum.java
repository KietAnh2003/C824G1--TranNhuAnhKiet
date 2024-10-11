package ss3_method;
import java.util.Arrays;
import java.util.Scanner;

public class SumColum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Nhập hàng
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
        // Nhập cột
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
        // nhập phần tử
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
        }// in mảng 2 chiều
        System.out.println("Arrays is: " + Arrays.deepToString(array) );
        // tính tổng của cột
        System.out.print("Enter the column to calculate the total (0 -> 4): ");
        int column = sc.nextInt();
        if (column >= 0 && column < columns) {
            double sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += array[i][column];
            }
            System.out.println("Sum of column elements " + column + " is: " + sum);
        } else {
            System.out.println("Invalid column!");
        }
    }
}
