package com.example.testing.service.impl;

import com.example.testing.entity.Book;
import com.example.testing.repository.BookRepository;
import com.example.testing.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book create(Book book) {
        return repository.save(book);
    }

    @Override
    public Book getBook(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public Book update(Long id, Book book) {

        Book existingBook = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());

        return repository.save(existingBook);
    }

    @Override
    public void delete(Long id) {

        Book existingBook = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        repository.delete(existingBook);
    }
}