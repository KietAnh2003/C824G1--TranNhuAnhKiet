package case_study.repository;

import case_study.entity.PhoneBookContact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookRepository {

    private static final String SIM1_FILE = "src/case_study/data/sim1.dat";
    private static final String SIM2_FILE = "src/case_study/data/sim2.dat";

    public List<PhoneBookContact> getAllContactsFromSim1() {
        return readContactsFromFile(SIM1_FILE);
    }
    public List<PhoneBookContact> getAllContactsFromSim2() {
        return readContactsFromFile(SIM2_FILE);
    }
    public void saveContactsToSim1(List<PhoneBookContact> contacts) {
        writeContactsToFile(SIM1_FILE, contacts);
    }
    public void saveContactsToSim2(List<PhoneBookContact> contacts) {
        writeContactsToFile(SIM2_FILE, contacts);
    }
    // Đọc liên hệ từ file
    private List<PhoneBookContact> readContactsFromFile(String fileName) {
        List<PhoneBookContact> contacts = new ArrayList<>();
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();  // Tạo file mới nếu chưa tồn tại
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            contacts = (List<PhoneBookContact>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Không thể đọc từ file " + fileName + ": " + e.getMessage());
        }
        return contacts;
    }
    // Ghi liên hệ vào file
    private void writeContactsToFile(String fileName, List<PhoneBookContact> contacts) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(contacts);
            oos.close();
        } catch (IOException e) {
            System.out.println("Không thể ghi vào file " + fileName + ": " + e.getMessage());
        }
    }

    // Thêm liên hệ vào Sim1
    public void addContactToSim1(PhoneBookContact contact) {
        List<PhoneBookContact> sim1Contacts = getAllContactsFromSim1();
        sim1Contacts.add(contact);
        saveContactsToSim1(sim1Contacts);
    }
    // Thêm liên hệ vào Sim2
    public void addContactToSim2(PhoneBookContact contact) {
        List<PhoneBookContact> sim2Contacts = getAllContactsFromSim2(); // Lấy danh sách liên hệ từ Sim2
        sim2Contacts.add(contact);  // Thêm liên hệ vào danh sách
        saveContactsToSim2(sim2Contacts);  // Lưu lại vào file
    }
    // Đồng bộ Sim1 sang Sim2
    public void syncSim1ToSim2() {
        List<PhoneBookContact> sim1Contacts = getAllContactsFromSim1();
        List<PhoneBookContact> sim2Contacts = getAllContactsFromSim2();

        // Chuyển tất cả liên hệ của Sim1 sang Sim2 nếu chưa tồn tại
        for (PhoneBookContact contact : sim1Contacts) {
            if (!sim2Contacts.contains(contact)) {
                sim2Contacts.add(contact);
            }
        }
        // Lưu lại vào file
        saveContactsToSim2(sim2Contacts);
    }
    // Đồng bộ Sim2 sang Sim1
    public void syncSim2ToSim1() {
        List<PhoneBookContact> sim1Contacts = getAllContactsFromSim1();
        List<PhoneBookContact> sim2Contacts = getAllContactsFromSim2();

        // Chuyển tất cả liên hệ của Sim2 sang Sim1 nếu chưa tồn tại
        for (PhoneBookContact contact : sim2Contacts) {
            if (!sim1Contacts.contains(contact)) {
                sim1Contacts.add(contact);
            }
        }
        // Lưu lại vào file
        saveContactsToSim1(sim1Contacts);
    }
}
