package com.pm.library.dto;

import com.pm.library.model.domain.Author;
import com.pm.library.model.domain.Country;

import java.util.List;
import java.util.stream.Collectors;

public record UpdateAuthorDto(Long id,String name, String surname, Long countryId, String countryName) {

    public static UpdateAuthorDto from(Author author) {
        return new UpdateAuthorDto(author.getId(),author.getName(), author.getSurname(), author.getCountry().getId(), author.getCountry().getName());
    }

    public Author toAuthor(Country country) {
        return new Author(name,surname,country);
    }

    public static List<UpdateAuthorDto> from(List<Author> authors) {
        return authors
                .stream()
                .map(UpdateAuthorDto::from)
                .collect(Collectors.toList());
    }
}
