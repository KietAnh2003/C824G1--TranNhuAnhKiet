package ss1_ss11.ss11_stack_queue.stack_integer;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseArrayInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            //Nhập phần tử
            System.out.println("Hãy nhập số lượng phần tử:");
            int numberOfElement = sc.nextInt();
            int[] array = new int[numberOfElement];
            for (int i = 0; i < array.length; i++) {
                System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
                int numbers = sc.nextInt();
                array[i] = numbers;

            }
            System.out.println("Mảng đã nhập là: " + Arrays.toString(array));
            // Đảo ngược mảng bằng stack
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < array.length; i++) {
                stack.push(array[i]);
            }

            for (int i = 0; i < array.length; i++) {
                array[i] = stack.pop();
            }

            System.out.println("Mảng đã đảo ngược:");
            for (int i : array) {
                System.out.print(i + " ");
            }
        } catch (Exception e) {
            System.out.println("Bạn đã nhập giá trị không hợp lệ!");
        }
    }
}
