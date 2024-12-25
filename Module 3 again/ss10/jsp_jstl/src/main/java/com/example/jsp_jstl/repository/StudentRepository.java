package com.example.jsp_jstl.repository;

import com.example.jsp_jstl.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static final List<Student> students = new ArrayList<>();



    public List<Student> getAll() {
        return students;
    }
}
