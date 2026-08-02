package com.example.testing.dto.response;

import java.util.List;

public class AuthorResponse {
    private Long id;
    private String name;
    private String email;
    private List<BookSummaryResponse> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BookSummaryResponse> getBooks() {
        return books;
    }

    public void setBooks(List<BookSummaryResponse> books) {
        this.books = books;
    }
}
