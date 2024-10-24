package ss1_ss11.ss1_java.ss2_loop;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr1 = new int[arr.length - 1];
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Hãy nhập 1 số từ 1 -> 9 để xóa số đó trong mảng:");
            int number = sc.nextInt();
            if (number < 0 || number > 9){
                System.out.println("Số không có trong mảng");
                return;
            }
            int i = 0;
            for (int j : arr) {
                if (number == j) {
                    continue;
                }
                arr1[i++] = j;
            }
            System.out.println("Mảng khi đã xóa phần tử " + number + " là " + Arrays.toString(arr1));
        } catch (Exception e){
            System.out.println("Giá trị không hợp lệ");
        }
    }
}
