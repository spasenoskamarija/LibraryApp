package com.pm.library.service.domain;


import com.pm.library.model.domain.Book;
import com.pm.library.model.domain.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> save(Book book);

    Optional<Book> findById(Long id);

    Optional<Book> update(Long id, Book book);

    void deleteById(Long id);

    Optional<Book> rentBook(Long id);

    Optional<Book> findByName(String name);

    void refreshMaterializedView();

    List<Book> findByCategory(Category category);

    List<Book> getAvailableBooks();

}
