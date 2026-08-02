package com.example.testing.mapper;
import com.example.testing.dto.request.CreateBookRequest;
import com.example.testing.dto.response.BookResponse;
import com.example.testing.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = AuthorMapper.class
)
public interface BookMapper {
    BookResponse toResponse(Book book);

    List<BookResponse> toResponses(List<Book> books);

    Book toEntity(CreateBookRequest request);
}