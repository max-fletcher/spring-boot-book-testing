package com.example.testing.service;

import com.example.testing.dto.request.CreateBookRequest;
import com.example.testing.dto.request.UpdateBookRequest;
import com.example.testing.dto.response.BookResponse;
import java.util.List;

public interface BookService {
    List<BookResponse> getAllBooks();

    BookResponse getBook(Long id);

    BookResponse create(CreateBookRequest request);

    BookResponse update(Long id, UpdateBookRequest request);

    void delete(Long id);
}