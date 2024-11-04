package ss12_ss23.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileByteNumber {
    public static void main(String[] args) {
        File file = new File("src/ss12_ss23/test/dataByte.dat");
        try (FileInputStream fis = new FileInputStream(file)) {
            int byteData;
            // Đọc từng byte từ file cho đến khi đạt đến cuối file (read() trả về -1)
            while ((byteData = fis.read()) != -1) {
                System.out.print(byteData + " "); // In giá trị byte đọc được ra màn hình
            }
        } catch (IOException e) {
            e.printStackTrace(); // Bắt lỗi nếu có ngoại lệ IOException
        }
    }
}
