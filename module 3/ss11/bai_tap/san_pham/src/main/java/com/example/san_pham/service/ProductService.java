package com.example.san_pham.service;

import com.example.san_pham.model.Product;
import com.example.san_pham.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    private static final ProductRepository productRepository = new ProductRepository();

    public List<Product>getAllProducts(){
        return productRepository.findAll();
    }
    public void addProduct(Product product){
        productRepository.addProduct(product);
    }
    public void deleteProduct(Integer productId){
        productRepository.deleteProduct(productId);
    }
    public void updateProduct(Product product){
        productRepository.updateProduct(product);
    }
    public Product getProductById(Integer id) {
        return productRepository.findProductById(id);
    }
    public List<Product> searchProductsByName(String query) {
        return productRepository.findProductsByName(query);
    }
}