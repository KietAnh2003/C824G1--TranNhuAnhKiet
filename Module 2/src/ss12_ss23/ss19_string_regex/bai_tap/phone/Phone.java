package ss12_ss23.ss19_string_regex.bai_tap.phone;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {
    private static final String PHONE = "^\\([0-9]{2}\\)-\\(0[0-9]{9}\\)$";
    private static Pattern pattern = Pattern.compile(PHONE);
    public static boolean validate(String phone){
        boolean result = false;
        Matcher matcher = pattern.matcher(phone);
        if(matcher.matches()){
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Valid phone numbers is: (xx)-(0xxxxxxxxx)");
        System.out.println("Please enter a string of phone numbers:");
        String phoneString = scanner.nextLine();
        if(validate(phoneString)){
            System.out.println("Phone is valid.");
        }else {
            System.out.println("Phone is NOT valid.");
        }
    }
}
