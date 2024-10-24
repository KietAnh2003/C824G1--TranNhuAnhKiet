package ss1_ss11.ss11_stack_queue.stack_string;

import java.util.Scanner;
import java.util.Stack;

public class ReverseArrayString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập chuỗi bạn muốn đảo ngược: ");
        String str = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        StringBuilder reversedStr = new StringBuilder();

        while (!stack.isEmpty()) {
            reversedStr.append(stack.pop());
        }

        System.out.println("Chuỗi sau khi đảo ngược: " + reversedStr.toString());
    }
}
