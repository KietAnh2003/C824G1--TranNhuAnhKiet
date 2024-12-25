package com.example.jsp_jstl.controller;

import com.example.jsp_jstl.model.Student;
import com.example.jsp_jstl.service.IStudentService;
import com.example.jsp_jstl.service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")

public class StudentController extends HttpServlet {
    private static final IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<Student> students = studentService.getAll();
        if (students == null || students.isEmpty()) {
            req.setAttribute("message", "Danh sách rỗng.");
        }
        req.setAttribute("students", students);
        req.getRequestDispatcher("WEB-INF/view/student/list.jsp").forward(req, resp);
    }
}
