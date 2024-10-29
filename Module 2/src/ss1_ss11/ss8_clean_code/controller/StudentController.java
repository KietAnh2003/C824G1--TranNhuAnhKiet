package  ss1_ss11.ss8_clean_code.controller;

import  ss1_ss11.ss8_clean_code.entity.Student;
import ss1_ss11.ss8_clean_code.service.IStudentService;
import  ss1_ss11.ss8_clean_code.service.impl.StudentService;
import java.util.List;

public class StudentController {
    //    DI nguyên lý D trong SOLID
    private static IStudentService studentService = new StudentService();

    public List<Student> getAll() {
        List<Student> students = studentService.getAll();
        return students;
    }
    public List<Student> addStudent() {
        List<Student> students = studentService.addStudent();
        return students;
    }

    public boolean editStudentByCode(long code, String name, String address, double point, String nameClass) {
        return studentService.editStudentByCode(code, name, address, point, nameClass);
    }
    public Student getStudentByCode(long code) {
        return studentService.getStudentByCode(code); // Cần thêm phương thức này trong service
    }



    public List<Student> displayAllStudentSortById() {
        return studentService.getAllSortById();
    }
}
