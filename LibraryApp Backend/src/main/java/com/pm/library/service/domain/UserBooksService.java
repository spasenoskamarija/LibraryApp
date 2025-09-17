package com.pm.library.service.domain;

import com.pm.library.model.domain.Author;
import com.pm.library.model.domain.Book;
import com.pm.library.model.domain.UserBooks;

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