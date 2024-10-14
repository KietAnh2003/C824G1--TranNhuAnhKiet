package ss2_loop;

import java.util.Arrays;
import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr1 = new int[arr.length + 1];
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Hãy nhập 1 số từ để thêm số đó vào mảng:");
            int element = sc.nextInt();

            System.out.println("Hãy nhập vị trí cần chèn:");
            int index = sc.nextInt();

            if (index < 0 || index > arr.length) {
                System.out.println("Vị trí không hợp lệ!");
                return;
            }
            int j = 0;
            for (int i = 0; i < arr1.length; i++) {
                if (i == index) {
                    arr1[i] = element;
                } else {
                    arr1[i] = arr[j];
                    j++;
                }
            }
            System.out.println("Mảng khi đã thêm phần tử " + element + " là " + Arrays.toString(arr1));
        } catch (Exception e){
            System.out.println("Ngoại lệ! Hãy nhập số ");
        }
    }
}
