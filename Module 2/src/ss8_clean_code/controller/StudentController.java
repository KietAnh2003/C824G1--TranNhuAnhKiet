package ss8_clean_code.controller;

import ss8_clean_code.service.IStudentService;
import ss8_clean_code.service.ipm.StudentService;

public class StudentController {
    private static IStudentService studentService = new StudentService();
    public static void getAll() {
    studentService.getAll();
    }
}

