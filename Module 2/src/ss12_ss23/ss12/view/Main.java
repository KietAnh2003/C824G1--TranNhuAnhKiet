package ss12_ss23.ss12.view;

import ss12_ss23.ss12.controller.ProductController;
import ss12_ss23.ss12.entity.Product;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductController manager = new ProductController();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("---- Mời bạn chọn chức năng ----");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xóa sản phẩm theo ID");
            System.out.println("3. Sửa sản phẩm theo ID");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần theo giá");
            System.out.println("7. Sắp xếp sản phẩm giảm dần theo giá");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm

            int id;
            double price;
            String name;

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID sản phẩm: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    name = scanner.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    price = scanner.nextDouble();
                    manager.addProduct(new Product(id, name, price));
                    break;
                case 2:
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    id = scanner.nextInt();
                    if (!manager.removeProductById(id)) {
                        System.out.println("Không tìm thấy sản phẩm với ID: " + id);
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID sản phẩm cần sửa: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Xóa bộ đệm
                    System.out.print("Nhập tên mới: ");
                    name = scanner.nextLine();
                    System.out.print("Nhập giá mới: ");
                    price = scanner.nextDouble();
                    manager.updateProductById(id, name, price);
                    if (!manager.updateProductById(id, name, price)) {
                        System.out.println("Không tìm thấy sản phẩm với ID: " + id);
                    }
                    break;
                case 4:
                    List<Product> products = manager.displayProducts();
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên sản phẩm cần tìm: ");
                    name = scanner.nextLine();
                    List<Product> foundProducts = manager.searchProductByName(name);
                    for (Product product : foundProducts) {
                        System.out.println(product);
                    }
                    break;
                case 6:
                    manager.sortProductsByPriceAscending();
                    System.out.println("Đã sắp xếp sản phẩm tăng dần theo giá.");
                    break;
                case 7:
                    manager.sortProductsByPriceDescending();
                    System.out.println("Đã sắp xếp sản phẩm giảm dần theo giá.");
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }
}
