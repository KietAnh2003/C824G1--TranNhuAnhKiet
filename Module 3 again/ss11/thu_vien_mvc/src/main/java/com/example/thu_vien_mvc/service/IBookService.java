package com.example.thu_vien_mvc.service;

import com.example.thu_vien_mvc.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();


    void save(Book book);

    Book getBookById(int id);

    void update(Book updateBook);
    void delete(Integer id);

    List<Book> searchBookByTitle(String query);
}
