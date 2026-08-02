package com.example.testing.controller;

import com.example.testing.dto.request.CreateBookRequest;
import com.example.testing.dto.request.CreateBookWithAuthorRequest;
import com.example.testing.dto.request.UpdateBookRequest;
import com.example.testing.dto.response.BookResponse;
import com.example.testing.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<BookResponse> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable Long id) {
        return service.getBook(id);
    }

    @PostMapping
    public BookResponse createBook(@Valid @RequestBody CreateBookRequest request) {
        return service.create(request);
    }

    @PostMapping("/create-with-author")
    public BookResponse createWithAuthor(@Valid @RequestBody CreateBookWithAuthorRequest request) {
        return service.createBookWithAuthor(request);
    }

    @PatchMapping("/{id}")
    public BookResponse updateBook(@PathVariable Long id, @Valid @RequestBody UpdateBookRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.delete(id);
    }
}