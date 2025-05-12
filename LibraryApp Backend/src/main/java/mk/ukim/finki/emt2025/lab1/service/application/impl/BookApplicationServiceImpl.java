package mk.ukim.finki.emt2025.lab1.service.application.impl;

import mk.ukim.finki.emt2025.lab1.dto.CreateAuthorDto;
import mk.ukim.finki.emt2025.lab1.dto.CreateBookDto;
import mk.ukim.finki.emt2025.lab1.dto.UpdateBookDto;
import mk.ukim.finki.emt2025.lab1.model.domain.Author;
import mk.ukim.finki.emt2025.lab1.model.domain.Category;
import mk.ukim.finki.emt2025.lab1.service.application.BookApplicationService;
import mk.ukim.finki.emt2025.lab1.service.domain.AuthorService;
import mk.ukim.finki.emt2025.lab1.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookApplicationServiceImpl implements BookApplicationService {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookApplicationServiceImpl(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public List<UpdateBookDto> getBooks() {
        return UpdateBookDto.from(bookService.findAll());
    }

    @Override
    public Optional<UpdateBookDto> getBookById(Long id) {
        return bookService.findById(id).map(UpdateBookDto::from);
    }

    @Override
    public Optional<UpdateBookDto> create(CreateBookDto createBookDto) {
        Optional<Author> author = authorService.findById(createBookDto.authorId());

        if (author.isPresent()) {
            return bookService.save(createBookDto.toBook(author.get())).map(UpdateBookDto::from);
        }
        return Optional.empty();
    }

    @Override
    public Optional<UpdateBookDto> update(Long id, CreateBookDto createBookDto) {
        Optional<Author> author = authorService.findById(createBookDto.authorId());
        return bookService.update(id, createBookDto.toBook(author.get())).map(UpdateBookDto::from);
    }

    @Override
    public void delete(Long id) {
        bookService.deleteById(id);
    }

    @Override
    public List<UpdateBookDto> findByCategory(Category category) {
        return UpdateBookDto.from(bookService.findByCategory(category));
    }

    public List<UpdateBookDto> getAvailableBooks () {
        return UpdateBookDto.from(bookService.getAvailableBooks());
    }
}
