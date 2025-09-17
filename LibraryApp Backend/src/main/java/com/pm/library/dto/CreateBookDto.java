package com.pm.library.dto;

import com.pm.library.model.domain.Author;
import com.pm.library.model.domain.Book;
import com.pm.library.model.domain.Category;

import java.util.List;
import java.util.stream.Collectors;

public record CreateBookDto(String name, String category, Long authorId, String authorName, Integer availableCopies, String description, String coverUrl) {

    public static CreateBookDto from(Book book) {
        return new CreateBookDto(book.getName(),book.getCategory().name().toUpperCase(),book.getAuthor().getId(), book.getAuthor().getName(),book.getAvailableCopies(), book.getDescription(), book.getCoverUrl());
    }

    public Book toBook(Author author) {
        return new Book(name,Category.valueOf(category.toUpperCase()),author,availableCopies,description,coverUrl);
    }

    public static List<CreateBookDto> from(List<Book> books) {
        return books
                .stream()
                .map(CreateBookDto::from)
                .collect(Collectors.toList());
    }


}
