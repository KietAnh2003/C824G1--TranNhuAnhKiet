package ss12_ss23.ss17.controller;

import ss12_ss23.ss17.entity.Product;
import ss12_ss23.ss17.service.ProductService;
import ss12_ss23.ss17.service.IProductService;

import java.util.List;
import java.util.Scanner;

public class ProductController {
    private IProductService productService;

    public ProductController() {
        this.productService = new ProductService();
    }

    public void addProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã sản phẩm: ");
        int id = scanner.nextInt();

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhập hãng sản xuất: ");
        String company = scanner.nextLine();

        System.out.print("Nhập mô tả sản phẩm: ");
        String description = scanner.nextLine();


        Product product = new Product(id, name, price, company, description);

        productService.addProduct(product);

        System.out.println("Sản phẩm đã được thêm");
    }
    public void showProducts() {
        List<Product> products = productService.getAllProduct();
        for (Product product : products) {
            System.out.println(product);
        }
    }
    public Product findProductById(int id){
        return productService.findProductById(id);
    }

}

