package ss4_ClassObj;
import java.util.Scanner;

public class QuadraticEquation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = getInput(sc, "Enter value for a:");
        double b = getInput(sc, "Enter value for b:");
        double c = getInput(sc, "Enter value for c:");

        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double delta = equation.getDiscriminant();

        if (delta > 0) {
            System.out.println("The equation has two roots: " + equation.getRoot1() + " and " + equation.getRoot2());
        } else if (delta == 0) {
            System.out.println("The equation has one root: " + equation.getRoot1());
        } else {
            System.out.println("The equation has no roots.");
        }
    }
    // Nhập xử lí ngoại lệ
    public static double getInput(Scanner sc, String message) {
        double input = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println(message);
                input = sc.nextDouble();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
        return input;
    }
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }
    public double getRoot1() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
        } else {
            return 0;
        }
    }
    public double getRoot2() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
        } else {
            return 0;
        }
    }
}
