package ss2_loop;
import java.util.Scanner;
public class DisplayPrime {
    public static void main(String[] args) {
        int count = 0;
        int currentNumber = 2;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhập số lượng số nguyên tố cần hiển thị: ");
            int number = sc.nextInt();
            if (number <= 0) {
                System.out.println("Số lượng số nguyên tố không hợp lệ");
                return;
            }
            System.out.println(number + " số nguyên tố đầu tiên là:");
            while (count < number) {
                if (isPrime(currentNumber)) {
                    System.out.print(currentNumber + " ");
                    count++;
                }
                currentNumber++;
            }
        } catch(Exception ex){
            System.out.println("Ngoại lệ! Hãy nhập một số hợp lệ");
        }
    }
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
