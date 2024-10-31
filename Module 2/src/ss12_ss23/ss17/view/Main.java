package ss12_ss23.ss17.view;

import ss12_ss23.ss17.controller.ProductController;
import ss12_ss23.ss17.entity.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("---- Quản lý sản phẩm ----");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Tìm sản phẩm theo id");
            System.out.println("4. Thoát");
            System.out.println("Chọn chức năng : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    productController.addProduct();
                    break;
                case 2:
                    productController.showProducts();
                    break;
                case 3:
                    while (true) {
                        try {
                            System.out.print("Nhập mã sản phẩm cần tìm: ");
                            int id = scanner.nextInt();
                            Product foundProduct = productController.findProductById(id);
                            if (foundProduct != null) {
                                System.out.println("Sản phẩm tìm thấy: " + foundProduct);
                            } else {
                                System.out.println("Không tìm thấy sản phẩm với mã: " + id);
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Hãy nhập số nguyên: ");
                        }
                    }
                case 4:
                    System.out.println("Đã thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại");
                    break;
            }
        } while (choice != 4);
    }
}
