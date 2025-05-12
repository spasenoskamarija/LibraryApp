package mk.ukim.finki.emt2025.lab1.service.domain;

import mk.ukim.finki.emt2025.lab1.model.domain.Author;
import mk.ukim.finki.emt2025.lab1.model.domain.Book;
import mk.ukim.finki.emt2025.lab1.model.domain.User;
import mk.ukim.finki.emt2025.lab1.model.domain.UserBooks;

import java.util.List;
import java.util.Optional;

public interface UserBooksService {
    // Додавање запис за изнајмување за даден корисник и книга
    Optional<UserBooks> rentUserBooks(Long bookId, String username);
    // Наоѓа сите записи за книга со даден id
    List<UserBooks> findAllByBookId(Long bookId);

    Optional<Book> findMostRentedBook();

    Optional<Author> findMostRentedAuthor();

    Optional<String> findMostActiveUser();
}