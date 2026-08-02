package com.example.testing.dto.request;

import jakarta.validation.constraints.*;

public class CreateBookWithAuthorRequest {
    @NotBlank(message = "Author name is required")
    @Size(max = 100, message = "Author name cannot be more than 100 characters long")
    private String authorName;

    @NotBlank(message = "Author email is required")
    @Size(max = 100, message = "Author email cannot be more than 100 characters long")
    @Email(message = "Invalid email. Please enter valid email address.")
    private String authorEmail;

    @NotBlank(message = "Book title is required")
    @Size(max = 100, message = "Book title cannot be more than 100 characters long")
    private String bookTitle;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    @Max(value = 1000, message = "Price cannot be more than 1000")
    private Double price;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
