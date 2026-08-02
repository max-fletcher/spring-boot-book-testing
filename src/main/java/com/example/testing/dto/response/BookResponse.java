package com.example.testing.dto.response;

public class BookResponse {
    private Long id;
    private String title;
    private Double price;
    private AuthorSummaryResponse author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public AuthorSummaryResponse getAuthor() {
        return author;
    }

    public void setAuthor(AuthorSummaryResponse author) {
        this.author = author;
    }
}
