package mk.ukim.finki.emt2025.lab1.service.domain.impl;

import mk.ukim.finki.emt2025.lab1.events.AuthorCreatedEvent;
import mk.ukim.finki.emt2025.lab1.model.domain.Author;
import mk.ukim.finki.emt2025.lab1.model.domain.Book;
import mk.ukim.finki.emt2025.lab1.repository.AuthorRepository;
import mk.ukim.finki.emt2025.lab1.repository.views.AuthorsPerCountryViewRepository;
import mk.ukim.finki.emt2025.lab1.service.domain.AuthorService;
import mk.ukim.finki.emt2025.lab1.service.domain.CountryService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryService countryService;
    private final AuthorsPerCountryViewRepository authorsPerCountryViewRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryService countryService, AuthorsPerCountryViewRepository authorsPerCountryViewRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.authorRepository = authorRepository;
        this.countryService = countryService;
        this.authorsPerCountryViewRepository = authorsPerCountryViewRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(Author author) {
        Optional<Author> savedAuthor = Optional.empty();

        if (author.getCountry().getId() != null &&
                countryService.findById(author.getCountry().getId()).isPresent()) {
            savedAuthor = Optional.of(
                    authorRepository.save(new Author(
                            author.getName(),
                            author.getSurname(),
                            countryService.findById(author.getCountry().getId()).get()
                    )));
            this.applicationEventPublisher.publishEvent(new AuthorCreatedEvent(author));
        }
        return savedAuthor;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> update(Long id, Author author) {
        return authorRepository.findById(id)
                .map(existingAuthor -> {
                    if (author.getName() != null) {
                        existingAuthor.setName(author.getName());
                    }
                    if (author.getSurname() != null) {
                        existingAuthor.setSurname(author.getSurname());
                    }
                    if (author.getCountry().getId() != null && countryService.findById(author.getCountry().getId()).isPresent()) {
                        existingAuthor.setCountry(countryService.findById(author.getCountry().getId()).get());
                    }
                    Author updatedAuthor = authorRepository.save(existingAuthor);
                    this.applicationEventPublisher.publishEvent(new AuthorCreatedEvent(author));
                    return updatedAuthor;
                });
    }

    @Override
    public void deleteById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        author.ifPresent(a -> {
            authorRepository.deleteById(id);
            this.applicationEventPublisher.publishEvent(new AuthorCreatedEvent(a));
        });
    }

    @Override
    public void refreshMaterializedView() {
        authorsPerCountryViewRepository.refreshMaterializedView();
    }

    @Override
    public List<Author> findAllAuthorsByCountry(Long countryId) {
        return authorRepository.findAllByCountryId(countryId);
    }

}
