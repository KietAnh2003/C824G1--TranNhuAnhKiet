package ss1_ss11.ss1_java;

import java.util.Scanner;

public class ChangeMoney {
//    public static void main(String[] args) {
//        double vnd = 25000;
//        double exchange;
//        Scanner sc = new Scanner(System.in);
//            try {
//                System.out.println("Nhập số tiền USD: ");
//                exchange = sc.nextDouble();
//                if (exchange < 0) {
//                    System.out.println("Hãy nhập số tiền hợp lệ và lớn hơn 0");
//                } else {
//                    double usd = exchange * vnd;
//                    System.out.println("Giá tiền VNĐ là: " + usd);
//                }
//            } catch (Exception ex) {
//                System.out.println("Ngoại lệ: hãy nhập một số hợp lệ!");
//            }
//    }
public static int[] squareVal(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        arr[i] = arr[i] * arr[i];
    }
    return arr;
}
    public static void main(String[] args) {
        int[] array = {1, 5, 10, -2};
        int[] squaredArray = squareVal(array);

        System.out.print("Mảng sau khi bình phương các phần tử: ");
        for (int num : squaredArray) {
            System.out.print(num + " ");
        }
    }

}

