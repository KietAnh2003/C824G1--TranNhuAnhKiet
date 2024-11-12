package case_study.view;

import case_study.controller.PhoneBookController;
import case_study.entity.PhoneBookContact;
import case_study.input.Input;
import case_study.repository.PhoneBookRepository;
import case_study.service.PhoneBookService;

import java.util.List;
import java.util.Scanner;


public class Main {
    // tìm kiếm theo số, tên thử dùng contain tìm gần đúng
    // đồng bộ sim1 qua sim2 , và sim2 1qua 1]/
    static PhoneBookController controller = new PhoneBookController();
    private static final PhoneBookRepository repository = new PhoneBookRepository();
    private static final PhoneBookService service = new PhoneBookService();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("--- Menu danh bạ ---");
            System.out.println("1. Thêm liên hệ");
            System.out.println("2. Xóa liên hệ");
            System.out.println("3. Tìm kiếm liên hệ");
            System.out.println("4. Hiển thị danh bạ");
            System.out.println("5. Đồng bộ danh bạ");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Input.inputChoice();

            switch (choice) {
                case 1: addContact();break;
                case 2: deleteContact();break;
                case 3: searchContact();break;
                case 4: showAllContacts();break;
                case 5: syncContacts();break;
                case 0: System.out.println("Thoát chương trình.");break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }
    static Scanner scanner = new Scanner(System.in);

    private static void addContact() {
        System.out.println("Thêm liên hệ vào SIM1 (1) hoặc SIM2 (2): ");
        int simChoice = Input.inputChoiceOneTwo();
        List<PhoneBookContact> contactList;
        if (simChoice == 1) {
            contactList = repository.getAllContactsFromSim1();
        } else {
            contactList = repository.getAllContactsFromSim2();
        }
        //Nhập thông tin kiểm tra id trùng
        int id = Input.inputId(repository.getAllContactsFromSim1(), repository.getAllContactsFromSim2());
        String name = Input.inputName();
        String phoneNumber = Input.inputPhoneNumber();
        String email = Input.inputEmail();

        PhoneBookContact contact = new PhoneBookContact(id, name, phoneNumber, email, simChoice == 1 ? "SIM1" : "SIM2");

        if (simChoice == 1) {
            service.addContactToSim1(contact); // gọi thẳng service
        } else {
            controller.addContactToSim2(contact);
        }
    }

    private static void deleteContact() {
        System.out.println("Nhập lựa chọn xóa:");
        System.out.println("1. Xóa liên hệ theo ID");
        System.out.println("2. Xóa tất cả liên hệ");
        int deleteChoice = Input.inputChoiceOneTwo();

        if (deleteChoice == 1) {
            System.out.println("Xóa liên hệ từ SIM1 (1) hoặc SIM2 (2): ");
            int simChoice = Input.inputChoiceOneTwo();
            System.out.print("Nhập ID liên hệ để xóa: ");
            int id = Input.inputChoice();
            if (simChoice == 1) {
                controller.deleteContactFromSim1ById(id);
            } else {
                controller.deleteContactFromSim2ById(id);
            }
        } else if (deleteChoice == 2) {
            System.out.println("Chọn SIM để xóa tất cả liên hệ:");
            System.out.println("1. Xóa tất cả danh bạ trên SIM 1");
            System.out.println("2. Xóa tất cả danh bạ trên SIM 2");
            int simChoice = Input.inputChoiceOneTwo();
            if (simChoice == 1) {
                controller.deleteAllContactsFromSim1();
            } else if (simChoice == 2) {
                controller.deleteAllContactsFromSim2();
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private static void searchContact() {
        System.out.println("Tìm liên hệ theo Tên (1) hoặc Số điện thoại (2): ");
        int searchChoice = Input.inputChoiceOneTwo();
        if (searchChoice == 1) {
            System.out.print("Nhập tên để tìm kiếm: ");
            String name = Input.inputName();
            controller.searchContactByName(name);
        } else {
            System.out.print("Nhập số điện thoại để tìm kiếm: ");
            String phoneNumber = scanner.nextLine();
            controller.searchContactByPhoneNumber(phoneNumber);
        }
    }

    public static void showAllContacts() {
        System.out.println("Hiển thị danh bạ của SIM1 (1) hoặc SIM2 (2): ");
        int simChoice = Input.inputChoiceOneTwo();
        if (simChoice == 1) {
            controller.showAllContactsSim1();
        } else {
            controller.showAllContactsSim2();
        }
    }

    public static void syncContacts() {
        System.out.println("1. Đồng bộ SIM (1) sang SIM (2)");
        System.out.println("2. Đồng bộ SIM (2) sang SIM (1)");
        System.out.print("Nhập lựa chon: ");
        int syncChoice = Input.inputChoiceOneTwo();
        if(syncChoice == 1){
            controller.syncSim1ToSim2();
        }else{
            controller.syncSim2ToSim1();
        }
    }
}
