package com.example.thi_module_3.controller;

import com.example.thi_module_3.model.Product;
import com.example.thi_module_3.service.IProductService;
import com.example.thi_module_3.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
    private static final IProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("/WEB-INF/view/create.jsp").forward(req, resp);
                break;
            default:
                List<Product> products = productService.getAll();
                req.setAttribute("products", products);
                req.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if (action == null || action.isEmpty()) {
            action = "";
        }
        switch (action) {
            case "create":
                String name = req.getParameter("name");
                double price = Double.parseDouble(req.getParameter("price"));
                String discountRate = req.getParameter("discountRate");
                int stockQuantity = Integer.parseInt(req.getParameter("stockQuantity"));
                if (name == null || name.trim().isEmpty()) {
                    resp.sendRedirect("/products?action=create&error=Name is required");
                    return;
                }
                if (price <= 100) {
                    resp.sendRedirect("/products?action=create&error=Price must be greater than 100");
                    return;
                }
                List<String> validDiscounts = Arrays.asList("5%", "10%", "15%", "20%");
                if (!validDiscounts.contains(discountRate)) {
                    resp.sendRedirect("/products?action=create&error=Invalid discount rate");
                    return;
                }
                if (stockQuantity <= 10) {
                    resp.sendRedirect("/products?action=create&error=Stock must be greater than 10");
                    return;
                }
                Product product = new Product(name, price, Double.parseDouble(discountRate.replace("%", "")), stockQuantity);
                productService.create(product);
                resp.sendRedirect("/products?message=Product created successfully");
                break;
            default:
                resp.sendRedirect("/products");
        }
    }
}
