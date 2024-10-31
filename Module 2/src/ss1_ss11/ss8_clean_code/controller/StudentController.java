package  ss1_ss11.ss8_clean_code.controller;

import  ss1_ss11.ss8_clean_code.entity.Student;
import ss1_ss11.ss8_clean_code.service.IStudentService;
import  ss1_ss11.ss8_clean_code.service.impl.StudentService;
import java.util.List;

public class StudentController {
    //    DI nguyên lý D trong SOLID
    private static IStudentService studentService = new StudentService();

    public List<Student> getAll() {
        return studentService.getAll();
    }
    public List<Student> addStudent() {
        return studentService.addStudent();
    }

    public boolean editStudentByCode(long id, String name, String address, double point, String nameClass) {
        return studentService.editStudentByCode(id, name, address, point, nameClass);
    }
    public Student getStudentByCode(long code) {
        return studentService.getStudentByCode(code);
    }


    public List<Student> displayAllStudentSortById() {
        return studentService.getAllSortById();
    }
}
