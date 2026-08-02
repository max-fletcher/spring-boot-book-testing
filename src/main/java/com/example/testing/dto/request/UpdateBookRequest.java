package com.example.testing.dto.request;

import com.example.testing.validation.interfaces.AuthorExists;
import jakarta.validation.constraints.*;

public class UpdateBookRequest {
    @Size(max = 100, message = "Title cannot be more than 100 characters long")
    private String title;

    @Positive(message = "Price must be greater than zero")
    @Max(value = 1000, message = "Price cannot be more than 1000")
    private Double price;

    @NotNull(message = "Author is required")
    @AuthorExists()
    private Long authorId;

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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
