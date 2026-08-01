package com.example.testing.service;

import com.example.testing.entity.Author;
import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();

    Author getAuthor(Long id);

    Author create(Author author);

    Author update(Long id, Author author);

    void delete(Long id);
}
