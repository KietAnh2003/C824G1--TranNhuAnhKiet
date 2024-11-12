package case_study.service;

import case_study.entity.PhoneBookContact;
import case_study.repository.PhoneBookRepository;
import java.util.List;

public class PhoneBookService implements IPhoneBookService {
    private PhoneBookRepository phoneBookRepository = new PhoneBookRepository();

    // Thêm liên hệ vào SIM1
    @Override
    public void addContactToSim1(PhoneBookContact contact) {
        List<PhoneBookContact> contacts = phoneBookRepository.getAllContactsFromSim1();
        contacts.add(contact);
        phoneBookRepository.saveContactsToSim1(contacts);
    }

    // Thêm liên hệ vào SIM2
    @Override
    public void addContactToSim2(PhoneBookContact contact) {
        List<PhoneBookContact> contacts = phoneBookRepository.getAllContactsFromSim2();
        contacts.add(contact);
        phoneBookRepository.saveContactsToSim2(contacts);
    }

    // Xóa liên hệ từ SIM1 theo ID
    @Override
    public void deleteContactFromSim1ById(int id) {
        List<PhoneBookContact> contacts = phoneBookRepository.getAllContactsFromSim1();
        PhoneBookContact removedContact = null;  // Biến lưu lại liên hệ bị xóa
        boolean found = false;

        // Duyệt qua danh sách để tìm ID
        for (PhoneBookContact contact : contacts) {
            if (contact.getId() == id) {
                removedContact = contact;  // Lưu thông tin liên hệ bị xóa
                contacts.remove(contact);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy liên hệ có ID: " + id);
        } else {
            // Hiển thị thông tin liên hệ đã xóa
            System.out.println("Đã xóa liên hệ: " + removedContact);
            phoneBookRepository.saveContactsToSim1(contacts);
        }
    }

    // Xóa liên hệ từ SIM2 theo ID
    @Override
    public void deleteContactFromSim2ById(int id) {
        List<PhoneBookContact> contacts = phoneBookRepository.getAllContactsFromSim2();
        PhoneBookContact removedContact = null;
        boolean found = false;
        // Duyệt qua danh sách để tìm ID

        for (PhoneBookContact contact : contacts) {
            if (contact.getId() == id) {
                removedContact = contact;
                contacts.remove(contact);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy liên hệ có ID: " + id);
        } else {
            // Hiển thị thông tin liên hệ đã xóa
            System.out.println("Đã xóa liên hệ: " + removedContact);
            phoneBookRepository.saveContactsToSim2(contacts);
        }
    }

    @Override
    public void deleteAllContactsFromSim1() {
        List<PhoneBookContact> contacts = phoneBookRepository.getAllContactsFromSim1();
        contacts.clear(); // Xóa tất cả các liên hệ trong danh sách
        phoneBookRepository.saveContactsToSim1(contacts); // Lưu lại danh sách trống
        System.out.println("Đã xóa tất cả danh bạ trên SIM 1.");
    }

    @Override
    public void deleteAllContactsFromSim2() {
        List<PhoneBookContact> contacts = phoneBookRepository.getAllContactsFromSim2();
        contacts.clear(); // Xóa tất cả các liên hệ trong danh sách
        phoneBookRepository.saveContactsToSim2(contacts); // Lưu lại danh sách trống
        System.out.println("Đã xóa tất cả danh bạ trên SIM 2.");
    }

    // Tìm kiếm liên hệ theo tên (gần đúng)
    @Override
    public void searchContactByName(String name) {
        List<PhoneBookContact> contactsSim1 = phoneBookRepository.getAllContactsFromSim1();
        boolean found = false;

        // Duyệt qua danh sách SIM1
        for (PhoneBookContact contact : contactsSim1) {
            if (contact.getName().toLowerCase().contains(name.toLowerCase())) {  // Sử dụng contains để tìm gần đúng
                System.out.println(contact);
                found = true;
            }
        }
        List<PhoneBookContact> contactsSim2 = phoneBookRepository.getAllContactsFromSim2();
        // Duyệt qua danh sách SIM2
        for (PhoneBookContact contact : contactsSim2) {
            if (contact.getName().toLowerCase().contains(name.toLowerCase())) {  // Sử dụng contains để tìm gần đúng
                System.out.println(contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy liên hệ.");
        }
    }

    // Tìm kiếm liên hệ theo số điện thoại (gần đúng)
    @Override
    public void searchContactByPhoneNumber(String phoneNumber) {
        List<PhoneBookContact> contactsSim1 = phoneBookRepository.getAllContactsFromSim1();
        boolean found = false;

        // Duyệt qua danh sách SIM1
        for (PhoneBookContact contact : contactsSim1) {
            if (contact.getPhoneNumber().contains(phoneNumber)) {  // Sử dụng contains để tìm gần đúng
                System.out.println(contact);
                found = true;
            }
        }
        List<PhoneBookContact> contactsSim2 = phoneBookRepository.getAllContactsFromSim2();
        // Duyệt qua danh sách SIM2
        for (PhoneBookContact contact : contactsSim2) {
            if (contact.getPhoneNumber().contains(phoneNumber)) {  // Sử dụng contains để tìm gần đúng
                System.out.println(contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy liên hệ.");
        }
    }

    // Hiển thị tất cả các liên hệ từ SIM1
    @Override
    public List<PhoneBookContact> showAllContactsSim1() {
        return phoneBookRepository.getAllContactsFromSim1();
    }

    // Hiển thị tất cả các liên hệ từ SIM2
    @Override
    public List<PhoneBookContact> showAllContactsSim2() {
        return phoneBookRepository.getAllContactsFromSim2();
    }

   @Override
    public void syncSim1ToSim2() {
        List<PhoneBookContact> contactsSim1 = phoneBookRepository.getAllContactsFromSim1();
        List<PhoneBookContact> contactsSim2 = phoneBookRepository.getAllContactsFromSim2();

        for (PhoneBookContact contact : contactsSim1) {
            // Kiểm tra nếu SIM2 chưa có liên hệ với ID tương ứng
            boolean idExistsInSim2 = false;
            for (PhoneBookContact contactSim2 : contactsSim2) {
                if (contactSim2.getId() == contact.getId()) {
                    idExistsInSim2 = true;
                    break;
                }
            }
            // Nếu ID không tồn tại trong SIM2, thêm liên hệ vào SIM2
            if (!idExistsInSim2) {
                phoneBookRepository.addContactToSim2(contact);
                System.out.println("Đã sao chép liên hệ từ SIM1 sang SIM2: " + contact);
            }
        }
    }

    // Đồng bộ SIM2 với SIM1
    @Override
    public void syncSim2ToSim1() {
        List<PhoneBookContact> contactsSim2 = phoneBookRepository.getAllContactsFromSim2();
        List<PhoneBookContact> contactsSim1 = phoneBookRepository.getAllContactsFromSim1();

        for (PhoneBookContact contact : contactsSim2) {
            // Kiểm tra nếu SIM1 chưa có liên hệ với ID tương ứng
            boolean idExistsInSim1 = false;
            for (PhoneBookContact contactSim1 : contactsSim1) {
                if (contactSim1.getId() == contact.getId()) {
                    idExistsInSim1 = true;
                    break;
                }
            }
            // Nếu ID không tồn tại trong SIM1, thêm liên hệ vào SIM1
            if (!idExistsInSim1) {
                phoneBookRepository.addContactToSim1(contact);
                System.out.println("Đã sao chép liên hệ từ SIM2 sang SIM1: " + contact);
            }
        }
    }
}
