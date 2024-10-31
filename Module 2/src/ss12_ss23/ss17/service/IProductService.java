package ss12_ss23.ss17.service;

import ss12_ss23.ss17.entity.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    List<Product> getAllProduct();
    Product findProductById(int id);
}