package ss11_stack_queue.check_palindrome;

import java.util.Scanner;
import java.util.Stack;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hãy nhập chuỗi bạn muốn kiểm tra: ");
        String str = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        // đẩy kí tự vào stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        String reversedStr = "";
        // đảo ngược chuỗi khi lấy ra từ stack
        while (!stack.isEmpty()) {
            reversedStr += stack.pop();
        }

        System.out.println("Chuỗi sau khi đảo ngược: " + reversedStr);
        // so sánh chuỗi đảo ngược
        if (str.equals(reversedStr)) {
            System.out.println("Chuỗi này là palindrome.");
        } else {
            System.out.println("Chuỗi này không phải là palindrome.");
        }
    }
}
