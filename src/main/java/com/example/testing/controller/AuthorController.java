package com.example.testing.controller;

import com.example.testing.entity.Author;
import com.example.testing.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return service.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id) {
        return service.getAuthor(id);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return service.create(author);
    }

    @PatchMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id,
                           @RequestBody Author author) {

        return service.update(id, author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        service.delete(id);
    }
}
