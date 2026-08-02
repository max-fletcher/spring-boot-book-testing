package com.example.testing.service.impl;

import com.example.testing.dto.request.CreateBookRequest;
import com.example.testing.dto.request.CreateBookWithAuthorRequest;
import com.example.testing.dto.request.UpdateBookRequest;
import com.example.testing.dto.response.AuthorSummaryResponse;
import com.example.testing.dto.response.BookResponse;
import com.example.testing.entity.Author;
import com.example.testing.entity.Book;
import com.example.testing.mapper.BookMapper;
import com.example.testing.repository.AuthorRepository;
import com.example.testing.repository.BookRepository;
import com.example.testing.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository repository, AuthorRepository authorRepository, BookMapper bookMapper) {
        this.repository = repository;
        this.authorRepository = authorRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookResponse> getAllBooks() {
        List<Book> books = repository.findAll();
        List<BookResponse> responses = new ArrayList<BookResponse>();

        // if you want to use DTO instead of mapStruct
        /*for (Book book : books) {
            responses.add(mapToBookResponse(book)); // push to ArrayList
        }
        return responses;*/

        return bookMapper.toResponses(books);
    }

    @Override
    public BookResponse create(CreateBookRequest request) {
        Long authorId = request.getAuthorId();
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setPrice(request.getPrice());
        book.setAuthor(author);
        Book savedBook = repository.save(book);

        // if you want to use DTO instead of mapStruct
        // return mapToBookResponse(savedBook);

        return bookMapper.toResponse(savedBook);
    }

    @Override
    public BookResponse getBook(Long id) {
        Book book =  repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        // if you want to use DTO instead of mapStruct
        // return mapToBookResponse(book);

        return bookMapper.toResponse(book);
    }

    @Override
    public BookResponse update(Long id, UpdateBookRequest request) {
        Long authorId = request.getAuthorId();
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));
        Book existingBook = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(request.getTitle());
        existingBook.setAuthor(author);
        existingBook.setPrice(request.getPrice());
        Book updatedBook = repository.save(existingBook);

        // if you want to use DTO instead of mapStruct
        // return mapToBookResponse(updatedBook);

        return bookMapper.toResponse(updatedBook);
    }

    @Override
    public void delete(Long id) {

        Book existingBook = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        repository.delete(existingBook);
    }

    @Transactional
    public BookResponse createBookWithAuthor(CreateBookWithAuthorRequest request) {
        Author author = new Author();
        author.setName(request.getAuthorName());
        author.setEmail(request.getAuthorEmail());
        author = authorRepository.save(author);

        Book book = new Book();
        book.setTitle(request.getBookTitle());
        book.setPrice(request.getPrice());
        book.setAuthor(author);
        book = repository.save(book);

        // if you want to use DTO instead of mapStruct
        // return mapToBookResponse(book);

        return bookMapper.toResponse(book);
    }

    private BookResponse mapToBookResponse(Book book) {
        AuthorSummaryResponse authorDto = new AuthorSummaryResponse();
        authorDto.setId(book.getAuthor().getId());
        authorDto.setName(book.getAuthor().getName());

        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setPrice(book.getPrice());
        response.setAuthor(authorDto);

        return response;
    }
}