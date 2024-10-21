package ss8_clean_code.view;

import ss8_clean_code.controller.StudentController;

import java.util.Scanner;

public class MainView  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----Quản lí CodeGym-----");
        System.out.println("1. Quản lý học sinh");
        System.out.println("2. Quản lý giảng viên");
        System.out.println("3. Thoát");
        System.out.println("Mời bạn nhập lựa chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 :
                menuStudent();
                break;
            case 2:
                menuTeacher();
                break;
        }
    }

    private static void menuTeacher() {
        System.out.println("Quản lý giảng viên");
        System.out.println("1. Hiển thị danh sách");
        System.out.println("2. Thêm mới danh sách");
        System.out.println("3. Sửa");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm giảng viên theo tên, id");
    }

    private static void menuStudent() {
        StudentController student = new StudentController();
        System.out.println("Quản lý học sinh ");
        System.out.println("1. Hiển thị danh sách");
        System.out.println("2. Thêm mới danh sách");
        System.out.println("3. Sửa");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm học sinh theo tên, id");
        System.out.println("Mời bạn nhập lựa chọn:");
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());
        switch(choice){
            case 1 :
                System.out.println("Hiển thị danh sách học sinh");;
                StudentController.getAll();
                break;
            case 2 :
                System.out.println("Thêm mới học sinh");
                break;
                case 3 :
                System.out.println("Sửa thông tin học sinh");
                break;
                case 4 :
                System.out.println("Xóa thông tin học sinh");
                break;
        }
    }
}
