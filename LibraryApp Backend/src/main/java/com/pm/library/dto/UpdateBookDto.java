package com.pm.library.dto;

import com.pm.library.model.domain.Author;
import com.pm.library.model.domain.Book;
import com.pm.library.model.domain.Category;

import java.util.List;
import java.util.stream.Collectors;

public record UpdateBookDto(Long id, String name, String category, Long authorId, String authorName, Integer availableCopies, String description, String coverUrl) {

    public static UpdateBookDto from(Book book) {
        return new UpdateBookDto(
                book.getId(),
                book.getName(),
                book.getCategory().name().toUpperCase(),
                book.getAuthor() != null ? book.getAuthor().getId() : null,
                book.getAuthor() != null ? book.getAuthor().getName() : null,
                book.getAvailableCopies(),
                book.getDescription(),
                book.getCoverUrl()
        );
    }

    public Book toBook(Author author) {
        return new Book(name,Category.valueOf(category.toUpperCase()),author,availableCopies,description,coverUrl);
    }

    public static List<UpdateBookDto> from(List<Book> books) {
        return books
                .stream()
                .map(UpdateBookDto::from)
                .collect(Collectors.toList());
    }
}
