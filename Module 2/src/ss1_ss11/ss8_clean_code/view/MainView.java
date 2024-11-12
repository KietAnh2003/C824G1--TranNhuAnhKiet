package ss1_ss11.ss8_clean_code.view;

import ss1_ss11.ss8_clean_code.controller.StudentController;

import java.util.Scanner;
import ss1_ss11.ss8_clean_code.entity.Student;

import java.util.List;
import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        while (true) {
            System.out.println("--------- Quản lý CodeGym ------------");
            System.out.println("1. Quản lý học sinh");
            System.out.println("2. Quản lý giảng viên");
            System.out.println("3. Thoát");
            int choice = inputPropertyNumberInteger("lựa chọn");
            switch (choice) {
                case 1:
                    menuStudent();
                    break;
                case 2:
                    System.out.println("Quản lý giảng viên");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Bạn nhập không đúng lựa chọn. Vui lòng nhập lại.");
            }
        }

    }

    public static void menuStudent() {
        StudentController studentController = new StudentController();
        while (true) {
            System.out.println("Menu quản lý học sinh");
            System.out.println("1. Hiển thị danh sách học sinh");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Sửa thông tin học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Tìm kiếm học sinh theo tên hoặc id");
            System.out.println("6. Sắp xếp học sinh theo tên hoặc id");
            System.out.println("7. Quay lại menu chính");
            Scanner scanner = new Scanner(System.in);
            int choice = inputPropertyNumberInteger("lựa chọn");
            List<Student> students;

                switch (choice) {
                    case 1:
                        System.out.println("Hiển thị danh sách học sinh");
                        students = studentController.getAll();
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println(students.get(i));
                        }
                        break;
                    case 2:
                        List<Student> updatedStudents = studentController.addStudent();
                        System.out.println("Danh sách học sinh sau khi thêm:");
                        for (Student student : updatedStudents) {
                            System.out.println(student);
                        }
                        break;
                    case 3:
                        while (true) {
                            try {
                                System.out.println("Nhập mã học sinh cần sửa:");
                                long codeToEdit = inputPropertyNumberInteger("mã học sinh");

                                Student studentToEdit = studentController.getStudentByCode(codeToEdit);

                                if (studentToEdit == null) {
                                    System.out.println("Không tìm thấy học sinh với mã đã cho! NHẬP LẠI");
                                    continue;
                                }

                                System.out.println("Nhập tên mới:");
                                String newName = scanner.nextLine();
                                System.out.println("Nhập địa chỉ mới:");
                                String newAddress = scanner.nextLine();
                                System.out.println("Nhập điểm mới:");
                                double newPoint = Double.parseDouble(scanner.nextLine());
                                System.out.println("Nhập lớp mới:");
                                String newClassName = scanner.nextLine();

                                boolean isEdited = studentController.editStudentByCode(codeToEdit, newName, newAddress, newPoint, newClassName);
                                if (isEdited) {
                                    System.out.println("Sửa thông tin học sinh thành công.");
                                } else {
                                    System.out.println("Không tìm thấy học sinh với mã đã cho.");
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid input, please try again.");
                            }
                        }


                    case 4:
                        System.out.println("Xóa học sinh");
                        break;
                    case 5:
                        System.out.println("Tìm kiếm học sinh theo tên hoặc id");
                        break;
                    case 6:
                        sortStudent(scanner, studentController);
                        break;
                    case 7:
                        return;
                }
        }

    }

    public static void sortStudent(Scanner scanner, StudentController studentController) {
        List<Student> students;
        int subChoice;
        System.out.println("Bạn muốn sắp xếp theo:");
        System.out.println("1. Theo tên");
        System.out.println("2. Theo id");
        subChoice = Integer.parseInt(scanner.nextLine());
        if (subChoice == 1) {
            students = studentController.displayAllStudentSortById();
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i));
            }

        } else if (subChoice == 2) {

        } else {
            System.out.println("Invalid");
        }
    }

    public static int inputPropertyNumberInteger(String key){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập " + key + ":");
        int value ;
        while (true) {
            try {
                value = Integer.parseInt(scanner.nextLine());
                if(value < 0) {
                    System.out.print("Số phải là nguyên dương. Mời bạn nhập lại: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("Bạn cần nhập định dạng số nguyên: ");
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
        }
        return value;
    }
}