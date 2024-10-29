package ss1_ss11.ss8_clean_code.service.impl;

import ss12_ss23.ss12.entity.Product;
import ss1_ss11.ss8_clean_code.entity.Student;
import ss1_ss11.ss8_clean_code.repository.StudentRepository;
import ss1_ss11.ss8_clean_code.service.IStudentService;
import ss1_ss11.ss8_clean_code.sort.ComparatorStudentById;

import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static StudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> getAll() {
        List<Student> students = studentRepository.getAll();

        return students;
    }

    public List<Student> addStudent() {
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        String name = null;
        String address = null;
        double point = 0;
        String className = null;
        try {
            System.out.print("Nhập ID: ");
            id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập tên: ");
            name = scanner.nextLine();
            System.out.print("Nhập địa chỉ: ");
            address = scanner.nextLine();
            System.out.print("Nhập điểm: ");
            point = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập tên lớp: ");
            className = scanner.nextLine();
        }catch(Exception e){
            System.out.println("Invalid");
        }

        Student student = new Student((int) id, name, address, point, className);

        studentRepository.addStudent(student);

        return studentRepository.getAll();
    }
    public boolean editStudentByCode(long code, String name, String address, double point, String className) {
        return studentRepository.editStudentByCode(code, name, address, point, className);
    }

    public Student getStudentByCode(long code) {
        return studentRepository.getStudentByCode(code); // Cần thêm phương thức này trong repository
    }




    @Override
    public List<Student> getAllSortById() {
        List<Student> students = studentRepository.getAll();
        students.sort(new ComparatorStudentById());
        return students;
    }
}