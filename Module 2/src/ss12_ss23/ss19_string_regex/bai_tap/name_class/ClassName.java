package ss12_ss23.ss19_string_regex.bai_tap.name_class;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassName{
    private static final String CLASS_NAME_REGEX = "^[CAP][0-9]{4}[GHIK]$";
    private static Pattern pattern = Pattern.compile(CLASS_NAME_REGEX);

    public static boolean validate(String className) {
//        boolean result = false;
//        Matcher matcher = pattern.matcher(className);
//        if (matcher.matches()) {
//            result = true;
//        }
//        return result;
        Matcher matcher = pattern.matcher(className);
        return matcher.matches();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Valid name begin with C,A,P, 4 char from 0-9, end with G,H,I,K! ");
        System.out.println("Enter class name: ");
        String className1 = scanner.nextLine();

        if (validate(className1)){
            System.out.println("Class name is valid.");
        }else {
            System.out.println("Class name is NOT valid.");
        }
    }
}
