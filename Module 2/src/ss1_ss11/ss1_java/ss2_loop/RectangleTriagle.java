package ss1_ss11.ss1_java.ss2_loop;

import java.util.Scanner;

public class RectangleTriagle {
    public static void main(String[] args) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("1. To draw rectagle");
            System.out.println("2. To draw square triagle");
            System.out.println("3. To draw isosceles triagle");
            System.out.println("4. To Exit");
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 6; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    for (int i = 5; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    System.out.println();

                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    for (int i = 1; i <= 6; i++) {
                        for (int j = i; j < 6; j++) {
                            System.out.print("  ");
                        }
                        for (int j = 1; j <= (2 * i - 1); j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("No choice!");
            }
        }
    }
}

