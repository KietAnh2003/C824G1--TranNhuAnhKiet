package ss12_ss23.ss12.repository;

import ss12_ss23.ss12.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProductById(int id) {
        productList.removeIf(product -> product.getId() == id);
    }

    public Product getProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return productList;
    }
}
