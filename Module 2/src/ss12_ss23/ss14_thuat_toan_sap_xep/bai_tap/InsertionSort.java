package ss12_ss23.ss14_thuat_toan_sap_xep.bai_tap;

import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] list;
        int size;
        //nhập
        try {
            System.out.print("Enter the size of the array: ");
            size = sc.nextInt();
            list = new int[size];

            for (int i = 0; i < size; i++) {
                System.out.print("Please enter the element " + (i + 1) + " : ");
                list[i] = sc.nextInt();
            }

        } catch (Exception e) {
            System.out.println("Invalid value");
            return;
        }
        //mảng hiện tại
        System.out.println("Current array is : ");
        printArray(list);
        //gọi sắp xếp
        insertionSort(list);
        //hiển thị lại mảng sắp xếp
        System.out.println("Array after sort is : ");
        printArray(list);
    }

    public static void insertionSort(int[] array) {
        int index;
        int value;
        for (int i = 1; i < array.length; i++) {
            value = array[i];
            index = i;
            while (index > 0 && value < array[index - 1]) {
                array[index] = array[index - 1];
                index--;
            }
            array[index] = value;

            System.out.print("After insert " + value + ": ");
            printArray(array);
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
