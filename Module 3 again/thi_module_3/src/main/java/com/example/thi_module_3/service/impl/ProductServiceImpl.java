package com.example.thi_module_3.service.impl;

import com.example.thi_module_3.model.Product;
import com.example.thi_module_3.repository.ProductRepository;
import com.example.thi_module_3.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private static final ProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

}
