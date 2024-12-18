package ss12_ss23.ss12.repository;

import ss12_ss23.ss12.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    //Thêm điều kiện kiểm tra trước khi xóa
    public boolean removeProductById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getId() == id) {
                productList.remove(i);
                return true; //true nếu xóa thành công
            }
        }
        return false; //false nếu không tìm thấy
    }

    public Product getProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null; //null nếu không tìm thấy
    }

    public List<Product> getAllProducts() {
        return productList;
    }
}
