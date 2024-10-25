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
    public void updateProductById(int id, String newName, double newPrice) {
        Product product = productRepository.getProductById(id);
        if (product != null) {
            product.setName(newName);
            product.setPrice(newPrice);
        }
    }

    @Override
    public void removeProductById(int id) {
        productRepository.removeProductById(id);
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
        allProducts.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });
    }

    @Override
    public void sortProductsByPriceDescending() {
        List<Product> allProducts = productRepository.getAllProducts();
        allProducts.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p2.getPrice(), p1.getPrice());
            }
        });
    }
}
