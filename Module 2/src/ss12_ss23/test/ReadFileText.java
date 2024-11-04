package ss12_ss23.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileText {
    public static void main(String[] args) {
        File file = new File("src/ss12_ss23/test/dataText.txt");
        try (FileReader reader = new FileReader(file)) {
            int charData;
            while ((charData = reader.read()) != -1) {
                System.out.print((char) charData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}