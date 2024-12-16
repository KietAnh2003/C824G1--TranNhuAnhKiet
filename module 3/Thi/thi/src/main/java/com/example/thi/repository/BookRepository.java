package com.example.thi.repository;

import com.example.thi.model.Book;
import com.example.thi.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.thi.repository.BaseRepository.*;

public class BookRepository {

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";

        try (Connection conn = BaseRepository.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Book book = new Book();
                book.setBookCode(rs.getString("book_code"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setBookDescription(rs.getString("book_description"));
                book.setQuantity(rs.getInt("quantity"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection connection = DriverManager.getConnection(Url, User, Password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentCode(resultSet.getInt("studentCode"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setClassName(resultSet.getString("className"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}
