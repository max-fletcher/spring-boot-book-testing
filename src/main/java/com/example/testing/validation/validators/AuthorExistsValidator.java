package com.example.testing.validation.validators;

import com.example.testing.repository.AuthorRepository;
import com.example.testing.validation.interfaces.AuthorExists;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class AuthorExistsValidator implements ConstraintValidator<AuthorExists, Long> {

    private final AuthorRepository authorRepository;

    public AuthorExistsValidator(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public boolean isValid(Long authorId,
                           ConstraintValidatorContext context) {

        if (authorId == null) {
            return true; // Let @NotNull handle null values. Useful if this field is optional i.e update endpoint
        }

        return authorRepository.existsById(authorId);
    }
}