package com.example.jsp_jstl.repository;

import com.example.jsp_jstl.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("HV10001","Kiệt","Nam",100));
        students.add(new Student("HV10002","Kiệt","Nữ",90.5));
        students.add(new Student("HV10003","Kiệt","Nam",80.5));
        students.add(new Student("HV10004","Kiệt","Nữ",60.5));
        students.add(new Student("HV10005","Kiệt","Nam",59.9));
        students.add(new Student("HV10006","Kiệt","Nữ",40));
        students.add(new Student("HV10007","Kiệt","Nam",20));
    }


    public List<Student> getAll() {
        return students;
    }
}
