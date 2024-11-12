package case_study.service;

import case_study.entity.PhoneBookContact;

import java.util.List;

public interface IPhoneBookService {
    void addContactToSim1(PhoneBookContact contact);
    void addContactToSim2(PhoneBookContact contact);
    void deleteContactFromSim1ById(int id);
    void deleteContactFromSim2ById(int id);
    void searchContactByName(String name);
    void searchContactByPhoneNumber(String phoneNumber);
    List<PhoneBookContact> showAllContactsSim1();
    List<PhoneBookContact> showAllContactsSim2();
    void syncSim1ToSim2();
    void syncSim2ToSim1();
    void deleteAllContactsFromSim1();
    void deleteAllContactsFromSim2();
}
