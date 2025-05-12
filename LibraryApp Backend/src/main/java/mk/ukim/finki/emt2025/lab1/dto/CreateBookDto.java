package mk.ukim.finki.emt2025.lab1.dto;

import mk.ukim.finki.emt2025.lab1.model.domain.Author;
import mk.ukim.finki.emt2025.lab1.model.domain.Book;
import mk.ukim.finki.emt2025.lab1.model.domain.Category;

import java.util.List;
import java.util.stream.Collectors;

public record CreateBookDto(String name, String category, Long authorId, Integer availableCopies) {

    public static CreateBookDto from(Book book) {
        return new CreateBookDto(book.getName(),book.getCategory().name().toUpperCase(),book.getAuthor().getId(),book.getAvailableCopies());
    }

    public Book toBook(Author author) {
        return new Book(name,Category.valueOf(category.toUpperCase()),author,availableCopies);
    }

    public static List<CreateBookDto> from(List<Book> books) {
        return books
                .stream()
                .map(CreateBookDto::from)
                .collect(Collectors.toList());
    }


}
