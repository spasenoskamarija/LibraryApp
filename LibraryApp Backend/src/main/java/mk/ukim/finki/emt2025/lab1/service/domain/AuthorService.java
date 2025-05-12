package mk.ukim.finki.emt2025.lab1.service.domain;

import mk.ukim.finki.emt2025.lab1.model.domain.Author;
import mk.ukim.finki.emt2025.lab1.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> save(Author author);

    Optional<Author> findById(Long id);

    Optional<Author> update(Long id, Author author);

    void deleteById(Long id);

    void refreshMaterializedView();

    List<Author> findAllAuthorsByCountry(Long countryId);
}
