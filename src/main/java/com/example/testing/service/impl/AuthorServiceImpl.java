package com.example.testing.service.impl;

import com.example.testing.entity.Author;
import com.example.testing.repository.AuthorRepository;
import com.example.testing.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    @Override
    public Author create(Author author) {
        return repository.save(author);
    }

    @Override
    public Author getAuthor(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public Author update(Long id, Author author) {

        Author existingAuthor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        existingAuthor.setName(author.getName());
        existingAuthor.setEmail(author.getEmail());

        return repository.save(existingAuthor);
    }

    @Override
    public void delete(Long id) {

        Author existingAuthor = repository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));

        repository.delete(existingAuthor);
    }
}