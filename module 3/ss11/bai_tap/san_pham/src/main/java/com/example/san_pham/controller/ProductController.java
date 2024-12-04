package com.example.san_pham.controller;

import com.example.san_pham.model.Product;
import com.example.san_pham.service.IProductService;
import com.example.san_pham.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productController", urlPatterns = "/product")
public class ProductController extends HttpServlet {
    private static final IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                req.getRequestDispatcher("WEB-INF/view/product/add.jsp").forward(req, resp);
                break;
            case "remove":
                int id = Integer.parseInt(req.getParameter("idProduct"));
                productService.deleteProduct(id);
                resp.sendRedirect("/product");
                break;
            case "update":
                int editId = Integer.parseInt(req.getParameter("idProduct"));
                Product productToUpdate = productService.getProductById(editId);
                req.setAttribute("product", productToUpdate);
                req.getRequestDispatcher("WEB-INF/view/product/edit.jsp").forward(req, resp);
                break;
            case "search":
                String searchQuery = req.getParameter("query");
                List<Product> searchResults = productService.searchProductsByName(searchQuery);
                req.setAttribute("products", searchResults);
                req.getRequestDispatcher("WEB-INF/view/product/list.jsp").forward(req, resp);
                break;
            default:
                List<Product> products = productService.getAllProducts();
                req.setAttribute("products", products);
                req.getRequestDispatcher("WEB-INF/view/product/list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                Integer productId = Integer.parseInt(req.getParameter("productId"));
                String name = req.getParameter("name");
                double price = Double.parseDouble(req.getParameter("price"));
                String description = req.getParameter("description");
                Product product = new Product(productId, name, price, description);
                productService.addProduct(product);
                resp.sendRedirect("/product");
                break;
            case "update":
                Integer id = Integer.parseInt(req.getParameter("productId"));
                String updatedName = req.getParameter("name");
                double updatedPrice = Double.parseDouble(req.getParameter("price"));
                String updatedDescription = req.getParameter("description");
                Product updatedProduct = new Product(id, updatedName, updatedPrice, updatedDescription);
                productService.updateProduct(updatedProduct);
                resp.sendRedirect("/product");
                break;
        }
    }
}