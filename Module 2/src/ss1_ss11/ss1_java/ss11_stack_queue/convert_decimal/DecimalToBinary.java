package ss1_ss11.ss1_java.ss11_stack_queue.convert_decimal;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = 0;

        try {
            System.out.print("Nhập một số thập phân không âm: ");
            decimal = scanner.nextInt();

            if (decimal == 0) {
                System.out.println("Số nhị phân là: 0");
            }
        } catch (Exception e) {
            System.out.println("Bạn đã nhập giá trị không hợp lệ.");
            scanner.next();
        }

        Stack<Integer> stack = new Stack<>();
        int currentNumber = decimal;

        while (currentNumber > 0) {
            int remainder = currentNumber % 2;
            stack.push(remainder); // Đẩy số dư vào Stack
            currentNumber /= 2;
        }

        String binary = "";
        while (!stack.isEmpty()) {
            binary += stack.pop(); // Lấy đỉnh stack đẩy vào binary thành thập phân
        }
        System.out.println("Số nhị phân là: " + binary);
    }
}

