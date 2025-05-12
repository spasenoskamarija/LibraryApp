package mk.ukim.finki.emt2025.lab1.dto;

import mk.ukim.finki.emt2025.lab1.model.domain.Author;
import mk.ukim.finki.emt2025.lab1.model.domain.Book;
import mk.ukim.finki.emt2025.lab1.model.domain.Category;

import java.util.List;
import java.util.stream.Collectors;

public record UpdateBookDto(Long id, String name, String category, Long authorId, Integer availableCopies) {

    public static UpdateBookDto from(Book book) {
        return new UpdateBookDto(
                book.getId(),
                book.getName(),
                book.getCategory().name().toUpperCase(),
                book.getAuthor() != null ? book.getAuthor().getId() : null,
                book.getAvailableCopies()
        );
    }

    public Book toBook(Author author) {
        return new Book(name,Category.valueOf(category.toUpperCase()),author,availableCopies);
    }

    public static List<UpdateBookDto> from(List<Book> books) {
        return books
                .stream()
                .map(UpdateBookDto::from)
                .collect(Collectors.toList());
    }
}
