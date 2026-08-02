package com.example.testing.service;

import com.example.testing.dto.request.CreateAuthorRequest;
import com.example.testing.dto.request.UpdateAuthorRequest;
import com.example.testing.dto.response.AuthorResponse;
import java.util.List;

public interface AuthorService {
    List<AuthorResponse> getAllAuthors();

    AuthorResponse getAuthor(Long id);

    AuthorResponse create(CreateAuthorRequest request);

    AuthorResponse update(Long id, UpdateAuthorRequest request);

    void delete(Long id);
}
