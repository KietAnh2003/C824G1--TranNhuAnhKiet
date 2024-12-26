package com.example.thu_vien_mvc.controller;

import com.example.thu_vien_mvc.model.Book;
import com.example.thu_vien_mvc.service.IBookService;
import com.example.thu_vien_mvc.service.impl.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookController", value = "/book")
public class BookController extends HttpServlet {
    private static final IBookService bookService = new BookService();

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
            case "update":
                int id = Integer.parseInt(req.getParameter("id"));
                Book bookUpdate = bookService.getBookById(id);
                req.setAttribute("book", bookUpdate);
                req.getRequestDispatcher("/WEB-INF/view/update.jsp").forward(req, resp);
                break;
            case "delete":
                try {
                    Integer idToDelete = Integer.parseInt(req.getParameter("id"));
                    Book bookToDelete = bookService.getBookById(idToDelete);
                    if (bookToDelete != null) {
                        bookService.delete(idToDelete);
                        resp.sendRedirect("book?message=delete_success");
                    } else {
                        resp.sendRedirect("book?message=notfound");
                    }
                } catch (NumberFormatException e) {
                    resp.sendRedirect("book?message=error");
                }
                break;
            case "search":
                String searchTitle = req.getParameter("title");
                List<Book> searchResults = bookService.searchBookByTitle(searchTitle);
                req.setAttribute("books", searchResults);
                req.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(req, resp);
                break;
            default:
                List<Book> books = bookService.getAll();
                req.setAttribute("books", books);
                req.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String title = req.getParameter("title");
                String pageSize = req.getParameter("pageSize");
                String author = req.getParameter("author");
                String category = req.getParameter("category");
                Book book = new Book(title, Integer.parseInt(pageSize), author, category);
                bookService.save(book);
                resp.sendRedirect("/book?message=created");
                break;
            case "update":
                Integer id = Integer.parseInt(req.getParameter("id"));
                String updatedTitle = req.getParameter("title");
                Integer updatedPageSize = Integer.parseInt(req.getParameter("pageSize"));
                String updatedAuthor = req.getParameter("author");
                String updatedCategory = req.getParameter("category");

                Book updateBook = new Book(id, updatedTitle, updatedPageSize, updatedAuthor, updatedCategory);
                bookService.update(updateBook);

                resp.sendRedirect("/book?message=update_success");
                break;
        }
    }
}
