package com.example.testing.dto.request;

import com.example.testing.validation.interfaces.AuthorExists;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class UpdateBookRequest {
    @Size(max = 100, message = "Title cannot be more than 100 characters long")
    private String title;

    @Positive(message = "Price must be greater than zero")
    @Max(value = 1000, message = "Price cannot be more than 1000")
    private BigDecimal price;

    @NotNull(message = "Author is required")
    @AuthorExists()
    private Long authorId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
