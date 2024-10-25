package ss12_ss23.ss13.thuat_toan_tim_kiem;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Mảng khởi tạo có 5 phần tử, hãy nhập số nguyên hợp lệ.");
        //nhập phần tử
        for (int i = 0; i < arr.length; i++) {
            while (true) {
                try {
                    System.out.print("Hãy nhập phần tử thứ " + (i + 1) + " :");
                    arr[i] = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Bạn đã nhập giá trị không hợp lệ. Vui lòng nhập số nguyên.");
                    sc.nextLine();
                }
            }
        }
        //gọi hàm sort
        sortArray(arr);
        System.out.println("Mảng đã sắp xếp: " + Arrays.toString(arr));

        System.out.println("Hãy nhập giá trị cần tìm kiếm: ");
        int value = sc.nextInt();
        // gọi hàm tìm kiếm và lưu vị trí tìm thấy vào biến
        int index = binarySearch(arr, 0, arr.length - 1, value);

        // gọi hàm thông báo tìm thấy
        String resultMessage = getSearchResultMessage(index, value);
        System.out.println(resultMessage);
    }

    public static void sortArray(int[] array) {
        Arrays.sort(array);
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;

        if (array[middle] == value) {
            return middle;
        } else if (array[middle] < value) {
            return binarySearch(array, middle + 1, right, value);
        } else if (array[middle] > value) {
            return binarySearch(array, left, middle - 1, value);
        }
        return -1;
    }

    public static String getSearchResultMessage(int index, int value) {
        if (index != -1) {
            return "Giá trị '" + value + "' được tìm thấy ở vị trí: " + index;
        } else {
            return "Giá trị " + value + " không có trong mảng.";
        }
    }
}
