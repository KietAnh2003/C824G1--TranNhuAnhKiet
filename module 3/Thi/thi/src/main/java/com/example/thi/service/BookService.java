package com.example.thi.service;

import com.example.thi.model.Book;
import com.example.thi.model.Student;
import com.example.thi.repository.BaseRepository;
import com.example.thi.repository.BookRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepository();
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
    public Book getBookByCode(String bookCode) {
        Book book = null;
        String query = "SELECT * FROM books WHERE bookCode = ?";
        try (Connection conn = BaseRepository.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, bookCode);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                book = new Book();
                book.setBookCode(rs.getString("bookCode"));
                book.setBookName(rs.getString("bookName"));
                book.setAuthor(rs.getString("author"));
                book.setBookDescription(rs.getString("bookDescription"));
                book.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
    public void updateBook(Book book) {
        String query = "UPDATE books SET quantity = ? WHERE bookCode = ?";
        try (Connection conn = BaseRepository.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, book.getQuantity());
            stmt.setString(2, book.getBookCode());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Student> getAllStudents() {
        return bookRepository.getAllStudents();
    }
}
