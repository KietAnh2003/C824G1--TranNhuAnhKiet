package ss12_ss23.ss12.controller;

import ss12_ss23.ss12.entity.Product;
import ss12_ss23.ss12.service.IProductService;
import ss12_ss23.ss12.service.ProductService;
import java.util.List;

public class ProductController {
    private IProductService productService = new ProductService();

    public void addProduct(Product product) {
        productService.addProduct(product);
    }

    public void updateProductById(int id, String newName, double newPrice) {
        productService.updateProductById(id, newName, newPrice);
    }

    public void removeProductById(int id) {
        productService.removeProductById(id);
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
