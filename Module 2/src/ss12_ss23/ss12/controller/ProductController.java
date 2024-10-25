package ss12_ss23.ss12.controller;

import ss12_ss23.ss12.entity.Product;
import ss12_ss23.ss12.service.IProductService;
import ss12_ss23.ss12.service.ProductService;
import java.util.List;

public class    ProductController {
    private IProductService productService = new ProductService();

    public void addProduct(Product product) {
        productService.addProduct(product);
    }
    // thêm điều kiện khi không tìm thấy phần tử để sửa đôi
    public boolean updateProductById(int id, String newName, double newPrice) {
        if (!productService.updateProductById(id, newName, newPrice)) {
            System.out.println("Không tìm thấy sản phẩm với ID: " + id);
        }
        return false;
    }

    public boolean removeProductById(int id) {
        productService.removeProductById(id);
        return false;
    }

    public List<Product> displayProducts() {
        return productService.displayProducts();
    }

    public List<Product> searchProductByName(String name) {
        return productService.searchProductByName(name);
    }

    public void sortProductsByPriceAscending() {
        productService.sortProductsByPriceAscending();
    }

    public void sortProductsByPriceDescending() {
        productService.sortProductsByPriceDescending();
    }
}
