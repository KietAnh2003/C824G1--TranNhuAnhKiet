package ss12_ss23.ss16_text_file.thuc_hanh;

import java.io.*;

public class SimpleFileExample {
    public static void main(String[] args) throws IOException {
        // Ghi dữ liệu vào file
        FileWriter writer = new FileWriter("output.txt"); // Tạo đối tượng FileWriter
        writer.write("Hello, world!"); // Ghi dữ liệu vào file
        writer.close(); // Đóng file sau khi ghi
        System.out.println("Data written to file successfully.");

        // Đọc dữ liệu từ file
        FileReader reader = new FileReader("output.txt"); // Tạo đối tượng FileReader
        int data;
        System.out.println("Data read from file:");
        while ((data = reader.read()) != -1) {
            System.out.print((char) data); // Đọc từng ký tự và in ra
        }
        reader.close(); // Đóng file sau khi đọc
    }
}


