package ss1_ss11.ss11_stack_queue.stack_integer;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseArrayInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            //Nhập phần tử, lớn hơn 0 và nhỏ hơn MAX của kiểu Integer
            System.out.println("Hãy nhập số lượng phần tử:");
            int numberOfElement = sc.nextInt();
            //Điều kiện nhập
            if (numberOfElement <= 0 || numberOfElement >= Integer.MAX_VALUE) {
                System.out.println("Số lượng phần tử phải là số nguyen dương và nhỏ hơn " + Integer.MAX_VALUE);
                return;
            }

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
