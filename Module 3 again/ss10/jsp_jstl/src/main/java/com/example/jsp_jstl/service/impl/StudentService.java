package com.example.jsp_jstl.service.impl;

import com.example.jsp_jstl.model.Student;
import com.example.jsp_jstl.repository.StudentRepository;
import com.example.jsp_jstl.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private static final StudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> getAll() {
        List<Student> students = studentRepository.getAll();

        return students;
    }

}
