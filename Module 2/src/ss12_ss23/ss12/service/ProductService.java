package ss12_ss23.ss12.service;

import ss12_ss23.ss12.entity.Product;
import ss12_ss23.ss12.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductService implements IProductService {
    private ProductRepository productRepository = new ProductRepository();

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public boolean updateProductById(int id, String newName, double newPrice) {
        Product product = productRepository.getProductById(id);
        if (product != null) {
            product.setName(newName);
            product.setPrice(newPrice);
            return true; // Trả về true nếu cập nhật thành công
        }
        return false; // Trả về false nếu không tìm thấy
    }

    @Override
    public boolean removeProductById(int id) {
        return productRepository.removeProductById(id); // Gọi hàm từ repository
    }

    @Override
    public List<Product> displayProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> allProducts = productRepository.getAllProducts();
        List<Product> result = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public void sortProductsByPriceAscending() {
        List<Product> allProducts = productRepository.getAllProducts();
        allProducts.sort(Comparator.comparingDouble(Product::getPrice)); // Sử dụng biểu thức lambda
    }

    @Override
    public void sortProductsByPriceDescending() {
        List<Product> allProducts = productRepository.getAllProducts();
        allProducts.sort(Comparator.comparingDouble(Product::getPrice).reversed()); // Sử dụng biểu thức lambda
    }
}
