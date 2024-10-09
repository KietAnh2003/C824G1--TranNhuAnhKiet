package ss1;

import java.util.Scanner;

public class chuyen_doi_tien_te {
    public static void main(String[] args) {
        double vnd = 25000;
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập số tiền USD: ");
        usd = sc.nextDouble();
        double quyDoi = usd * vnd;
        System.out.println("Giá tiền VNĐ là:  " + quyDoi);
    }
}


