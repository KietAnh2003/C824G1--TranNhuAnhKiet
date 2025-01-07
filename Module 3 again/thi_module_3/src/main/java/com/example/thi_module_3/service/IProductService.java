package com.example.thi_module_3.service;

import com.example.thi_module_3.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    void create(Product product);

}
