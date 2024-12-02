package com.example.danh_sach_khach_hang.repository;

import com.example.danh_sach_khach_hang.model.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CustomerRepository {
    private static final List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer("Kiet1", LocalDate.now(), "Tổ 33, Trần Cao Vân","anh1.jpg "));
        customers.add(new Customer("Kiet2", LocalDate.now(), "Tổ 33, Trần Cao Vân","anh1.jpg "));
        customers.add(new Customer("Kiet3", LocalDate.now(), "Tổ 33, Trần Cao Vân","anh1.jpg "));
    }
    public List<Customer> getAll() {
        return customers;
    }
}
