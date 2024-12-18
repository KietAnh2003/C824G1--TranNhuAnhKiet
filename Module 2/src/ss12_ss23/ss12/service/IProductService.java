package ss12_ss23.ss12.service;

import ss12_ss23.ss12.entity.Product;
import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    boolean updateProductById(int id, String newName, double newPrice);
    boolean removeProductById(int id); // Sửa kiểu trả về thành boolean
    List<Product> displayProducts();
    List<Product> searchProductByName(String name);
    void sortProductsByPriceAscending();
    void sortProductsByPriceDescending();
}
