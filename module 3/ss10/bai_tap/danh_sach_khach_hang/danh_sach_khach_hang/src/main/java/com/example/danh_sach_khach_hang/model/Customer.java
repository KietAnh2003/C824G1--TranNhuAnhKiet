package com.example.danh_sach_khach_hang.model;

import java.time.LocalDate;

public class Customer {
    private String name;
    private LocalDate dob;
    private String address;
    private String avatar;

    public Customer(String name, LocalDate dob, String address, String avatar) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
