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
         StudentRepository studentRepository = new StudentRepository();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Nhập mã ID học sinh: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập tên học sinh: ");
            String name = scanner.nextLine();

            System.out.print("Nhập địa chỉ: ");
            String address = scanner.nextLine();

            System.out.print("Nhập điểm: ");
            double point = Double.parseDouble(scanner.nextLine());

            System.out.print("Nhập tên lớp: ");
            String className = scanner.nextLine();

            Student student = new Student(id, name, address, point, className);

            studentRepository.addStudent(student);
            return studentRepository.getAll();
        }
    public boolean editStudentByCode(long code, String name, String address, double point, String className) {
        return studentRepository.editStudentByCode(code, name, address, point, className);
    }

    public Student getStudentByCode(long code) {
        return studentRepository.getStudentByCode(code);
    }



    @Override
    public List<Student> getAllSortById() {
        List<Student> students = studentRepository.getAll();
        students.sort(new ComparatorStudentById());
        return students;
    }
}