package ss12_ss23.ss12.repository;

import ss12_ss23.ss12.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }
    // thêm điều kiện nếu không tìm thấy id thì false
    public boolean removeProductById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getId() == id) {
                productList.remove(i);
                return true;
            }
        }
        return false;
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
