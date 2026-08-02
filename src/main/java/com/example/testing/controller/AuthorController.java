package com.example.testing.controller;

import com.example.testing.dto.request.CreateAuthorRequest;
import com.example.testing.dto.request.UpdateAuthorRequest;
import com.example.testing.dto.response.AuthorResponse;
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
    public List<AuthorResponse> getAllAuthors() {
        return service.getAllAuthors();
    }

    @GetMapping("/{id}")
    public AuthorResponse getAuthor(@PathVariable Long id) {
        return service.getAuthor(id);
    }

    @PostMapping
    public AuthorResponse createAuthor(@RequestBody CreateAuthorRequest request) {
        return service.create(request);
    }

    @PatchMapping("/{id}")
    public AuthorResponse updateAuthor(@PathVariable Long id,
                           @RequestBody UpdateAuthorRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        service.delete(id);
    }
}
