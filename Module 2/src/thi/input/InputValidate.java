package thi.input;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidate {
    public static String nhapMaBenhAn() {
        Scanner scanner = new Scanner(System.in);
        String maBenhAn;
        while (true) {
            System.out.print("Nhập mã bệnh án (BA-XXX, với X là số ): ");
            maBenhAn = scanner.nextLine().trim();
            if (maBenhAn.isEmpty()) {
                System.out.println("Mã bệnh án không được trống");
                continue;
            }
            if (validateBenhAn(maBenhAn)) {
                return maBenhAn;
            } else {
                System.out.println("Bạn đã nhập định dạng mã không hợp lệ!");
            }
        }
    }

    public static boolean validateBenhAn(String maBenhAn) {
        final String MABENHAN_REGEX = "BA-\\d{3}";
        Pattern pattern = Pattern.compile(MABENHAN_REGEX);
        Matcher matcher = pattern.matcher(maBenhAn);
        return matcher.matches();
    }

}
