package com.example.testing.mapper;
import com.example.testing.dto.request.CreateBookRequest;
import com.example.testing.dto.request.CreateBookWithAuthorRequest;
import com.example.testing.dto.response.BookResponse;
import com.example.testing.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import com.example.testing.dto.request.UpdateBookRequest;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = AuthorMapper.class
)
public interface BookMapper {
    BookResponse toResponse(Book book);

    List<BookResponse> toResponses(List<Book> books);

    Book toEntity(CreateBookRequest request);

    @Mapping(source = "bookTitle", target = "title")
    Book toEntityForCreateBookWithAuthor(CreateBookWithAuthorRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", ignore = true)
    void updateEntity(UpdateBookRequest request, @MappingTarget Book book);
}