package com.example.thu_vien_mvc.repository;

import com.example.thu_vien_mvc.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static final List<Book> books = new ArrayList<>();

    static {
        books.add(new Book(1,"Toán lớp 4",30,"Quốc Hường","Tự nhiên"));
        books.add(new Book(2,"Địa lý lớp 5",40,"Hải Nhật","Xã hội"));
        books.add(new Book(3,"Vật lý lớp 10",50,"Minh Huy","Tự Nhiên"));
        books.add(new Book(4,"Địa lý lớp 5",60,"Gia nghi","Xã hội"));
        books.add(new Book(5,"Bài tập sinh học lớp 7",70,"Linh Phương","Tự Nhiên"));
    }

    public List<Book> getAll(){
        return books;
    }

    public void save (Book book) {
        if (books.isEmpty()) {
            book.setId(1); //nếu danh sách rỗng, ID là 1
        } else {
            book.setId(books.get(books.size() - 1).getId() + 1);
        }
        books.add(book);
    }
    public void update (Book book){
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                books.set(i, book);
                return;
            }
        }
    }
    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
    public boolean delete(Integer id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }
    public List<Book> searchBookByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

}

