package com.example.testing.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateAuthorRequest {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot be more than 100 characters long")
    private String name;
    @NotBlank(message = "Email is required")
    @Size(max = 100, message = "Email cannot be more than 100 characters long")
    @Email(message = "Invalid Email. Please enter valid email address.")
    private String email;

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
}
