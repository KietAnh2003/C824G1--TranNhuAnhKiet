package ss12_ss23.ss16_text_file.bai_tap.copy_file_text;

import java.io.*;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên file nguồn: ");
        String sourceFilePath = scanner.nextLine();

        System.out.print("Nhập tên file đích: ");
        String targetFilePath = scanner.nextLine();
        //src/ss12_ss23/ss16_text_file/read_file/country.csv
        System.out.println("File nguồn: " + sourceFilePath);
        //src/target.txt
        System.out.println("File đích: " + targetFilePath);

        File sourceFile = new File(sourceFilePath);
        if (!sourceFile.exists()) {
            System.out.println("File nguồn không tồn tại!");
            return;
        }

        File targetFile = new File(targetFilePath);
        if (targetFile.exists()) {
            System.out.println("File đích đã tồn tại! Vui lòng chọn tên khác");
            return;
        }

        try (Reader reader = new FileReader(sourceFile);
             Writer writer = new FileWriter(targetFile)) {
            int character;
            int count = 0;
            while ((character = reader.read()) != -1) {
                writer.write(character);
                count++;
            }
            System.out.println("Đã sao chép " + count + " ký tự từ tệp nguồn sang tệp đích.");
        } catch (IOException e) {
            System.out.println("Lỗi khi sao chép tệp: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
