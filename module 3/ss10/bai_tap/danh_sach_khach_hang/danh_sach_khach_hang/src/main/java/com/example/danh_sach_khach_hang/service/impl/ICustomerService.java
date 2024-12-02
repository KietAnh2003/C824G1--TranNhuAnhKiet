package com.example.danh_sach_khach_hang.service.impl;

import java.util.List;

public interface ICustomerService<T> {
    List<T> getAll();
}