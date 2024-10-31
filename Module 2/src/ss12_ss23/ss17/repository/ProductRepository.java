package ss12_ss23.ss17.repository;

import ss12_ss23.ss17.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public void addProduct(Product product) {
        List<Product> products = getAllProduct();
        products.add(product);

        try (FileOutputStream fileOutputStream = new FileOutputStream("src/ss12_ss23/ss17/products.dat");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(products);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file ");
        }
    }

    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream("src/ss12_ss23/ss17/products.dat");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            products = (List<Product>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi đọc file");
        }
        return products;
    }

    public Product findProductById(int id) {
        List<Product> products = getAllProduct();
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}



