package com.example.danh_sach_khach_hang.controller;

import com.example.danh_sach_khach_hang.model.Customer;
import com.example.danh_sach_khach_hang.service.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerController", urlPatterns = "/customers")
public class CustomerController extends HttpServlet {

    private final CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<Customer> products = customerService.getAll();
        req.setAttribute("customers", products);
        req.getRequestDispatcher("/WEB-INF/view/customerList.jsp").forward(req, resp);
    }
}
