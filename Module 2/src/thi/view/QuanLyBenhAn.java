package thi.view;

import thi.controller.CapNhatBenhAn;

import java.util.Scanner;

public class QuanLyBenhAn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CapNhatBenhAn capNhatBenhAn = new CapNhatBenhAn();
        int choice;
        do {
            System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN ---");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách các bệnh án");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    capNhatBenhAn.themBenhAn();
                    break;
                case 2:
                    capNhatBenhAn.xoaBenhAn();
                    break;
                case 3:
                    capNhatBenhAn.xemDanhSachBenhAn();
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 4);
    }
}