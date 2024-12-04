package com.example.san_pham.service;

import com.example.san_pham.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    void addProduct(Product product);

    void deleteProduct(Integer id);

    void updateProduct(Product product);

    Product getProductById(Integer id);

    List<Product> searchProductsByName(String query);

}