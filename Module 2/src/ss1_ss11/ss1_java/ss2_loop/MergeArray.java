package ss1_ss11.ss1_java.ss2_loop;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int[] arr1 = new int[5];
            int[] arr2 = new int[7];
            int[] arr3 = new int[arr1.length + arr2.length];

            System.out.println("Nhập phần tử của mảng 1:");
            for (int i = 0; i < arr1.length; i++) {
                System.out.print("Phần tử " + (i + 1) + ": ");
                arr1[i] = sc.nextInt();
            }
            System.out.println("Nhập phần tử của mảng 2:");
            for (int i = 0; i < arr2.length; i++) {
                System.out.print("Phần tử " + (i + 1) + ": ");
                arr2[i] = sc.nextInt();
            }

            for (int i = 0; i < arr1.length; i++) {
                arr3[i] = arr1[i];
            }
            for (int i = 0; i < arr2.length; i++) {
                arr3[arr1.length + i] = arr2[i];
            }
            System.out.println("Mảng 3 sau khi gộp: " + Arrays.toString(arr3));

        } catch (Exception e) {
            System.out.println("Giá trị khong hợp lệ");
        }
    }
}
