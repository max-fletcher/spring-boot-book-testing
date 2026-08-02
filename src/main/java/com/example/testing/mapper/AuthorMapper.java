package com.example.testing.mapper;

import com.example.testing.dto.request.CreateAuthorRequest;
import com.example.testing.dto.response.AuthorResponse;
import com.example.testing.dto.response.AuthorSummaryResponse;
import com.example.testing.entity.Author;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorResponse toResponse(Author author);

    AuthorSummaryResponse toSummary(Author author);

    List<AuthorResponse> toResponses(List<Author> author);

    Author toEntity(CreateAuthorRequest request);
}