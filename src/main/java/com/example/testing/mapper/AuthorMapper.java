package com.example.testing.mapper;

import com.example.testing.dto.request.CreateAuthorRequest;
import com.example.testing.dto.request.CreateBookWithAuthorRequest;
import com.example.testing.dto.request.UpdateAuthorRequest;
import com.example.testing.dto.request.UpdateBookRequest;
import com.example.testing.dto.response.AuthorResponse;
import com.example.testing.dto.response.AuthorSummaryResponse;
import com.example.testing.entity.Author;
import com.example.testing.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorResponse toResponse(Author author);

    AuthorSummaryResponse toSummary(Author author);

    List<AuthorResponse> toResponses(List<Author> author);

    Author toEntity(CreateAuthorRequest request);

    @Mapping(source = "authorName", target = "name")
    @Mapping(source = "authorEmail", target = "email")
    Author toEntityForCreateBookWithAuthor(CreateBookWithAuthorRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    void updateEntity(UpdateAuthorRequest request, @MappingTarget Author author);
}