package com.example.testing.service;

import com.example.testing.entity.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBook(Long id);

    Book create(Book book);

    Book update(Long id, Book book);

    void delete(Long id);
}