package com.example.testing.service.impl;

import com.example.testing.dto.request.CreateAuthorRequest;
import com.example.testing.dto.request.UpdateAuthorRequest;
import com.example.testing.dto.response.AuthorResponse;
import com.example.testing.dto.response.BookSummaryResponse;
import com.example.testing.entity.Author;
import com.example.testing.entity.Book;
import com.example.testing.mapper.AuthorMapper;
import com.example.testing.repository.AuthorRepository;
import com.example.testing.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;
    private final AuthorMapper authorMapper;


    public AuthorServiceImpl(AuthorRepository repository, AuthorMapper authorMapper) {
        this.repository = repository;
        this.authorMapper = authorMapper;
    }

    @Override
    public List<AuthorResponse> getAllAuthors() {
        List<Author> authors = repository.findAll();
        List<AuthorResponse> responses = new ArrayList<AuthorResponse>();

        // if you want to use DTO instead of mapStruct
        /*for (Author author : authors) {
            responses.add(mapToAuthorResponse(author)); // push to ArrayList
        }

        return responses;*/

        return authorMapper.toResponses(authors);
    }

    @Override
    public AuthorResponse create(CreateAuthorRequest request) {
        // if you want to use DTO instead of mapStruct
        /*Author author = new Author();
        author.setName(request.getName());
        author.setEmail(request.getEmail());
        Author savedAuthor = repository.save(author);*/

        /*return mapToAuthorResponse(savedAuthor);*/

        Author author = authorMapper.toEntity(request);
        Author savedAuthor = repository.save(author);
        return authorMapper.toResponse(author);
    }

    @Override
    public AuthorResponse getAuthor(Long id) {
        Author author = repository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        // if you want to use DTO instead of mapStruct
        /*return mapToAuthorResponse(author);*/

        return authorMapper.toResponse(author);
    }

    @Override
    public AuthorResponse update(Long id, UpdateAuthorRequest request) {
        Author existingAuthor = repository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));

        // if you want to use DTO instead of mapStruct
        /*existingAuthor.setName(request.getName());
        existingAuthor.setEmail(request.getEmail());

        Author updatedAuthor = repository.save(existingAuthor);

        return mapToAuthorResponse(updatedAuthor);*/

        authorMapper.updateEntity(request, existingAuthor);
        Author updatedAuthor = repository.save(existingAuthor);
        return authorMapper.toResponse(updatedAuthor);
    }

    @Override
    public void delete(Long id) {

        Author existingAuthor = repository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));

        repository.delete(existingAuthor);
    }

    private AuthorResponse mapToAuthorResponse(Author author) {
        AuthorResponse response = new AuthorResponse();

        response.setId(author.getId());
        response.setName(author.getName());
        response.setEmail(author.getEmail());

        List<BookSummaryResponse> books = new ArrayList<>();

        if (author.getBooks() != null) {
            for (Book book : author.getBooks()) {
                BookSummaryResponse bookResponse = new BookSummaryResponse();
                bookResponse.setId(book.getId());
                bookResponse.setTitle(book.getTitle());
                books.add(bookResponse);
            }
        }

        response.setBooks(books);

        return response;
    }
}