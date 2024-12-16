package com.example.test_case_gio_hang;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Initialize cart
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            cart.add(new CartItem("Product A", 100.0, 1));
            cart.add(new CartItem("Product B", 200.0, 2));
            session.setAttribute("cart", cart);
        }

        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart != null) {
            String action = request.getParameter("action");
            int index = Integer.parseInt(request.getParameter("index"));

            if ("increase".equals(action)) {
                cart.get(index).setQuantity(cart.get(index).getQuantity() + 1);
            } else if ("decrease".equals(action) && cart.get(index).getQuantity() > 1) {
                cart.get(index).setQuantity(cart.get(index).getQuantity() - 1);
            }
        }

        response.sendRedirect("cart");
    }
}
