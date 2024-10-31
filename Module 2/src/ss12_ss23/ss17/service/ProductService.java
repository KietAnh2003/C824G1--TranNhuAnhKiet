package ss12_ss23.ss17.service;

import ss12_ss23.ss17.entity.Product;
import ss12_ss23.ss17.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    private ProductRepository productRepository = new ProductRepository();
    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    public Product findProductById(int id) {
        return  productRepository.findProductById(id);
    }

}

