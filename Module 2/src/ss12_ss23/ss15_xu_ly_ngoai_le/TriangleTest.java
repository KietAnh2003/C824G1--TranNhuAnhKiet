package ss12_ss23.ss15_xu_ly_ngoai_le;

import java.util.Scanner;

public class  TriangleTest{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập độ dài cạnh a: ");
            double a = scanner.nextDouble();

            System.out.print("Nhập độ dài cạnh b: ");
            double b = scanner.nextDouble();

            System.out.print("Nhập độ dài cạnh c: ");
            double c = scanner.nextDouble();

            checkTriangleSides(a, b, c);
            System.out.println("Đây là tam giác hợp lệ!");

        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Đầu vào không hợp lệ. Vui lòng nhập số.");
        } finally {
            scanner.close();
        }
    }

    public static void checkTriangleSides(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Độ dài các cạnh phải là số dương.");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng hai cạnh phải lớn hơn cạnh còn lại.");
        }
    }
}
