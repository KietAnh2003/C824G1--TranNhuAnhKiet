package case_study.controller;

import case_study.entity.PhoneBookContact;
import case_study.service.PhoneBookService;
import case_study.service.IPhoneBookService;

public class PhoneBookController {
    private static IPhoneBookService phoneBookService;

    public PhoneBookController() {
        phoneBookService = new PhoneBookService();
    }

    public void addContactToSim1(PhoneBookContact contact) {
        phoneBookService.addContactToSim1(contact);
    }

    public void addContactToSim2(PhoneBookContact contact) {
        phoneBookService.addContactToSim2(contact);
    }

    public void deleteContactFromSim1ById(int id) {
        phoneBookService.deleteContactFromSim1ById(id);
    }

    public void deleteContactFromSim2ById(int id) {
        phoneBookService.deleteContactFromSim2ById(id);
    }
    public void deleteAllContactsFromSim1() {
        phoneBookService.deleteAllContactsFromSim1();
    }

    public void deleteAllContactsFromSim2() {
        phoneBookService.deleteAllContactsFromSim2();
    }

    public void searchContactByName(String name) {
        phoneBookService.searchContactByName(name);
    }

    public void searchContactByPhoneNumber(String phoneNumber) {
        phoneBookService.searchContactByPhoneNumber(phoneNumber);
    }

    public void showAllContactsSim1() {
        phoneBookService.showAllContactsSim1().forEach(System.out::println);
    }

    public void showAllContactsSim2() {
        phoneBookService.showAllContactsSim2().forEach(System.out::println);
    }

    public void syncSim1ToSim2() {
        phoneBookService.syncSim1ToSim2();  // Gọi phương thức đồng bộ từ SIM1 sang SIM2 từ service
        System.out.println("Đã đồng bộ dữ liệu từ SIM1 sang SIM2.");
    }

    public void syncSim2ToSim1() {
        phoneBookService.syncSim2ToSim1();
        System.out.println("Đã đồng bộ dữ liệu từ SIM2 sang SIM1.");
    }
}
