package ss12_ss23.ss19_string_regex.thuc_hanh.EmailExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Lớp EmailExample dùng để kiểm tra tính hợp lệ của email dựa trên biểu thức chính quy
public class EmailExample {
    private static Pattern pattern; // pattern lưu trữ biểu thức chính quy đã biên dịch
    private Matcher matcher; // matcher để kiểm tra chuỗi đầu vào có khớp với pattern hay không

    // Biểu thức chính quy cho định dạng email hợp lệ
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    // Constructor: biên dịch biểu thức chính quy thành pattern
    public EmailExample() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    // Phương thức validate: kiểm tra chuỗi đầu vào (email) có khớp với EMAIL_REGEX không
    public boolean validate(String regex) {
        matcher = pattern.matcher(regex); // tạo matcher với chuỗi cần kiểm tra
        return matcher.matches(); // trả về true nếu chuỗi khớp với EMAIL_REGEX, ngược lại là false
    }
}

// Lớp EmailExampleTest dùng để kiểm tra tính hợp lệ của các email mẫu
class EmailExampleTest {
    private static EmailExample emailExample; // đối tượng EmailExample để gọi phương thức validate
    public static final String[] validEmail = new String[]{"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com"}; // mảng email hợp lệ
    public static final String[] invalidEmail = new String[]{"@gmail.com", "ab@gmail.", "@#abc@gmail.com"}; // mảng email không hợp lệ

    public static void main(String args[]) {
        emailExample = new EmailExample(); // khởi tạo đối tượng EmailExample

        // Kiểm tra từng email hợp lệ
        for (String email : validEmail) {
            boolean isvalid = emailExample.validate(email); // kiểm tra email hợp lệ
            System.out.println("Email is " + email + " is valid: " + isvalid); // in kết quả
        }

        // Kiểm tra từng email không hợp lệ
        for (String email : invalidEmail) {
            boolean isvalid = emailExample.validate(email); // kiểm tra email không hợp lệ
            System.out.println("Email is " + email + " is valid: " + isvalid); // in kết quả
        }
    }
}