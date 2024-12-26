package com.example.thu_vien_mvc.service.impl;

import com.example.thu_vien_mvc.model.Book;
import com.example.thu_vien_mvc.repository.BookRepository;
import com.example.thu_vien_mvc.service.IBookService;

import java.util.List;

public class BookService implements IBookService {
    private static final BookRepository bookRepository = new BookRepository();

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.delete(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void update(Book book) {
        bookRepository.update(book);
    }

    @Override
    public List<Book> searchBookByTitle(String title) {
        return bookRepository.searchBookByTitle(title);
    }
}
