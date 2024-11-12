package case_study.entity;

import java.io.Serializable;

public class PhoneBookContact implements Serializable {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String simType;  // Thuộc tính mới để lưu loại SIM

    public PhoneBookContact(int id, String name, String phoneNumber, String email, String simType) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.simType = simType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getSimType() {
        return simType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSimType(String simType) {
        this.simType = simType;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone number='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", simType='" + simType + '\'' +
                '}';
    }
}
