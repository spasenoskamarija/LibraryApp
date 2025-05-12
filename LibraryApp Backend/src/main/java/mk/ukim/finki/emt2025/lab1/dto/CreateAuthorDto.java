package mk.ukim.finki.emt2025.lab1.dto;

import mk.ukim.finki.emt2025.lab1.model.domain.Author;
import mk.ukim.finki.emt2025.lab1.model.domain.Country;

import java.util.List;
import java.util.stream.Collectors;

public record CreateAuthorDto(String name, String surname, Long countryId) {

    public static CreateAuthorDto from(Author author) {
        return new CreateAuthorDto(author.getName(), author.getSurname(), author.getCountry().getId());
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
