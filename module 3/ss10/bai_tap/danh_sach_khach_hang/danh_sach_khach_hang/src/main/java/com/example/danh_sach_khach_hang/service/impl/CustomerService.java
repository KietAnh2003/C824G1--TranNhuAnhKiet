package com.example.danh_sach_khach_hang.service.impl;

import com.example.danh_sach_khach_hang.model.Customer;
import com.example.danh_sach_khach_hang.repository.CustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {

    private static final CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }
}
