package com.example.thi.controller;

import com.example.thi.model.Book;
import com.example.thi.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookController extends HttpServlet {
    private final BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.getAllBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/books.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookCode = request.getParameter("bookCode");
        Book book = bookService.getBookByCode(bookCode);

        if (book != null && book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            bookService.updateBook(book);
            request.setAttribute("book", book);
            request.setAttribute("students", bookService.getAllStudents());
            request.getRequestDispatcher("/borrow.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Lỗi");
            request.getRequestDispatcher("/books.jsp").forward(request, response);
        }
    }
}
