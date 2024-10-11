package ss3_method;

import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        String str = "Hello, I'm Kiet, nice to meet you, do you want to get to know me?";
        System.out.println("String: " + str);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a character to count occurrences: ");
        char inputChar = scanner.next().charAt(0);

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == inputChar) {
                count++;
            }
        }
        System.out.println("The character '" + inputChar + "' appears " + count + " time(s) in the string.");
    }
}
