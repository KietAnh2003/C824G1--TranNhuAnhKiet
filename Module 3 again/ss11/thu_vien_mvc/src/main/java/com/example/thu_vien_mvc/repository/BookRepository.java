package com.example.thu_vien_mvc.repository;

import com.example.thu_vien_mvc.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static final List<Book> books = new ArrayList<>();

    public List<Book> getAll() {
        PreparedStatement statement = null;
        List<Book> books = new ArrayList<>();
        try {
            statement = BaseRepository.getConnection().prepareStatement("SELECT id, title, pageSize, author,category  FROM books  ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int pageSize = resultSet.getInt("pageSize");
                String author = resultSet.getString("author");
                String category = resultSet.getString("category");

                books.add(new Book(id, title, pageSize, author, category));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return books;
    }

    public void save(Book book) {
        try {
            int authorId = getAuthorId(book.getAuthor());
            int categoryId = getCategoryId(book.getCategory());
            String sql = "INSERT INTO books(title, page_size, id_author, id_category) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = BaseRepository.getConnection().prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getPageSize());
            statement.setInt(3, authorId);
            statement.setInt(4, categoryId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving book: " + e.getMessage());
        }
    }

    private int getAuthorId(String authorName) throws SQLException {
        // Kiểm tra xem tác giả đã tồn tại chưa
        String query = "SELECT id_author FROM authors WHERE name_author = ?";
        PreparedStatement ps = BaseRepository.getConnection().prepareStatement(query);
        ps.setString(1, authorName);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("id_author");
        } else {
            String insertQuery = "INSERT INTO authors(name_author) VALUES (?)";
            PreparedStatement insertPs = BaseRepository.getConnection().prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            insertPs.setString(1, authorName);
            int affectedRows = insertPs.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = insertPs.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
            throw new SQLException("Failed to insert author.");
        }
    }

    private int getCategoryId(String categoryName) throws SQLException {
        String query = "SELECT id_category FROM category WHERE name_category = ?";
        PreparedStatement ps = BaseRepository.getConnection().prepareStatement(query);
        ps.setString(1, categoryName);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("id_category");
        } else {
            String insertQuery = "INSERT INTO category(name_category) VALUES (?)";
            PreparedStatement insertPs = BaseRepository.getConnection().prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            insertPs.setString(1, categoryName);
            int affectedRows = insertPs.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = insertPs.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
            throw new SQLException("Failed to insert category.");
        }
    }

    public void update(Book book) {
        String sql = "UPDATE books SET title = ?, page_size = ?, id_author = ?, id_category = ? WHERE id_book = ?";
        try (PreparedStatement statement = BaseRepository.getConnection().prepareStatement(sql)) {
            // Thiết lập các giá trị trong câu lệnh SQL
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getPageSize());
            statement.setInt(3, getAuthorId(book.getAuthor()));
            statement.setInt(4, getCategoryId(book.getCategory()));
            statement.setInt(5, book.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Sách đã được cập nhật thành công!");
            } else {
                System.out.println("Không tìm thấy sách để cập nhật.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating book: " + e.getMessage());
        }
    }

    public Book getBookById(int id) {
        String sql = "SELECT * FROM books WHERE id_book = ?";
        try (PreparedStatement statement = BaseRepository.getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                // Tạo đối tượng Book từ dữ liệu trong ResultSet
                int bookId = rs.getInt("id_book");
                String title = rs.getString("title");
                int pageSize = rs.getInt("page_size");
                String author = getAuthorNameById(rs.getInt("id_author"));
                String category = getCategoryNameById(rs.getInt("id_category"));
                return new Book(bookId, title, pageSize, author, category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching book by ID: " + e.getMessage());
        }
        return null;
    }

    public List<Book> searchBookByTitle(String title) {
        List<Book> results = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title LIKE ?";
        try (PreparedStatement statement = BaseRepository.getConnection().prepareStatement(sql)) {
            statement.setString(1, "%" + title + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt("id_book");
                String bookTitle = rs.getString("title");
                int pageSize = rs.getInt("page_size");
                String author = getAuthorNameById(rs.getInt("id_author"));
                String category = getCategoryNameById(rs.getInt("id_category"));
                results.add(new Book(bookId, bookTitle, pageSize, author, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error searching books by title: " + e.getMessage());
        }
        return results;
    }

    private String getAuthorNameById(int authorId) throws SQLException {
        String sql = "SELECT name_author FROM authors WHERE id_author = ?";
        try (PreparedStatement statement = BaseRepository.getConnection().prepareStatement(sql)) {
            statement.setInt(1, authorId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("name_author");
            }
        }
        return null;
    }

    private String getCategoryNameById(int categoryId) throws SQLException {
        String sql = "SELECT name_category FROM category WHERE id_category = ?";
        try (PreparedStatement statement = BaseRepository.getConnection().prepareStatement(sql)) {
            statement.setInt(1, categoryId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("name_category");
            }
        }
        return null;
    }

    public void delete(int bookId) {
        try {
            String deleteBorrowsQuery = "DELETE FROM borrows WHERE id_book = ?";
            try (PreparedStatement stmt = BaseRepository.getConnection().prepareStatement(deleteBorrowsQuery)) {
                stmt.setInt(1, bookId);
                stmt.executeUpdate();
            }
            String deleteBooksQuery = "DELETE FROM books WHERE id_book = ?";
            try (PreparedStatement stmt = BaseRepository.getConnection().prepareStatement(deleteBooksQuery)) {
                stmt.setInt(1, bookId);
                stmt.executeUpdate();
            }
            String resetAutoIncrementQuery = "ALTER TABLE books AUTO_INCREMENT = 1";
            try (PreparedStatement stmt = BaseRepository.getConnection().prepareStatement(resetAutoIncrementQuery)) {
                stmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting book: " + e.getMessage());
        }
    }

}

