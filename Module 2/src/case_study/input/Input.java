package case_study.input;

import case_study.entity.PhoneBookContact;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    //Kiểm tra nhập ID hợp lệ
    public static int inputChoice() {
        int choice;
        while (true) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Giá trị không hợp lệ, hãy nhập lựa chon là số nguyên: ");
                scanner.nextLine();
            }
        }
        return choice;
    }
    //Kiểm tra nhập lựa chọn 1 hoặc 2
    public static int inputChoiceOneTwo() {
        int choiceOneTwo;
        while (true) {
            try {
                choiceOneTwo = scanner.nextInt();
                scanner.nextLine();
                if (choiceOneTwo != 1 && choiceOneTwo != 2) {
                    System.out.println("Không tồn tại lựa chọn. Vui lòng nhập 1 hoặc 2: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Giá trị không hợp lệ, hãy nhập lựa chọn là số nguyên (1 hoặc 2): ");
                scanner.nextLine();
            }
        }
        return choiceOneTwo;
    }

    //Kiểm tra nhập ID hợp lệ, tồn tại hay chưa
    public static int inputId(List<PhoneBookContact> contactsSim1, List<PhoneBookContact> contactsSim2) {
        int id;
        boolean idExists;

        do {
            System.out.print("Nhập ID liên hệ: ");
            id = inputChoice();
            idExists = false;
            // Kiểm tra ID tồn tại trong SIM1
            for (PhoneBookContact contact : contactsSim1) {
                if (contact.getId() == id) {
                    System.out.println("ID này đã tồn tại trong SIM1, vui lòng nhập lại.");
                    idExists = true;
                    break;
                }
            }
            // Kiểm tra ID tồn tại trong SIM2 nếu chưa có trong SIM1
            if (!idExists) {
                for (PhoneBookContact contact : contactsSim2) {
                    if (contact.getId() == id) {
                        System.out.println("ID này đã tồn tại trong SIM2, vui lòng nhập lại.");
                        idExists = true;
                        break;
                    }
                }
            }
        } while (idExists);

        return id;
    }

    //nhập TÊN bất kì
    public static String inputName() {
        String inputName;
        while (true) {
            System.out.print("Nhập tên: ");
            inputName = scanner.nextLine().trim();
            if (inputName.isEmpty()) {
                System.out.println("Tên không được để trống.");
                continue;
            }
            return inputName;
        }
    }
    //kiểm tra nhập SDT hợp lệ
    public static String inputPhoneNumber() {
        String phoneNumber;
        while (true) {
            System.out.print("Nhập số điện thoại: ");
            phoneNumber = scanner.nextLine().trim();
            if (phoneNumber.isEmpty()) {
                System.out.println("Số điện thoại không được trống.");
                continue;
            }
            return phoneNumber;
        }
    }
    //Nhập Mail
    public static String inputEmail() {
        String email;
        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine().trim();
            if (email.isEmpty()) {
                System.out.println("Email không được trống.");
                continue;
            }
            return email;
        }
    }
    // NHẬP ĐỊNH DẠNG
//    public static String inputPhoneNumber() {
//        String phoneNumber;
//        while (true) {
//            System.out.print("Nhập số điện thoại (XX-0XXXXXXXXX): ");
//            phoneNumber = scanner.nextLine().trim();
//            if (phoneNumber.isEmpty()) {
//                System.out.println("Số điện thoại không được trống");
//                continue;
//            }
//            if (validatePhone(phoneNumber)) {
//                return phoneNumber;
//            } else {
//                System.out.println("Bạn đã nhập số điện thoại không hợp lệ");
//            }
//        }
//    }
//    public static boolean validatePhone(String phone) {
//        final String PHONE_REGEX = "^\\d{2}-\\d{10}$";  //XX-0XXXXXXXXX
//        Pattern pattern = Pattern.compile(PHONE_REGEX);
//        Matcher matcher = pattern.matcher(phone);
//        return matcher.matches();
//    }
//    //kiểm tra nhập EMAIL hợp lệ
//    public static String inputEmail() {
//        String email;
//        while (true) {
//            System.out.print("Nhập email: ");
//            email = scanner.nextLine().trim();
//            if (email.isEmpty()) {
//                System.out.println("Email không được trống");
//                continue;
//            }
//            if (validateEmail(email)) {
//                return email;
//            } else {
//                System.out.println("Bạn đã nhập email không hợp lệ");
//            }
//        }
//    }
//    public static boolean validateEmail(String email) {
//        final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
//        Pattern pattern = Pattern.compile(EMAIL_REGEX);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//    }
}
