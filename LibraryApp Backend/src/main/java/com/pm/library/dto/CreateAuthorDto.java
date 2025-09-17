package com.pm.library.dto;

import com.pm.library.model.domain.Author;
import com.pm.library.model.domain.Country;

import java.util.List;
import java.util.stream.Collectors;

public record CreateAuthorDto(String name, String surname, Long countryId, String countryName) {

    public static CreateAuthorDto from(Author author) {
        return new CreateAuthorDto(author.getName(), author.getSurname(), author.getCountry().getId(), author.getCountry().getName());
    }

    public Author toAuthor(Country country) {
        return new Author(name,surname,country);
    }

    public static List<CreateAuthorDto> from(List<Author> authors) {
        return authors
                .stream()
                .map(CreateAuthorDto::from)
                .collect(Collectors.toList());
    }

}
