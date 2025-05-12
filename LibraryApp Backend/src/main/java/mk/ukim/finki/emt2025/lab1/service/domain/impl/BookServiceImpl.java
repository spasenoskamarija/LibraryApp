package mk.ukim.finki.emt2025.lab1.service.domain.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.emt2025.lab1.model.domain.Book;
import mk.ukim.finki.emt2025.lab1.model.domain.Category;
import mk.ukim.finki.emt2025.lab1.repository.BookRepository;
import mk.ukim.finki.emt2025.lab1.repository.views.BooksPerAuthorViewRepository;
import mk.ukim.finki.emt2025.lab1.service.domain.AuthorService;
import mk.ukim.finki.emt2025.lab1.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final BooksPerAuthorViewRepository booksPerAuthorViewRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, BooksPerAuthorViewRepository booksPerAuthorViewRepository) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.booksPerAuthorViewRepository = booksPerAuthorViewRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    @Override
    public Optional<Book> save(Book book) {
        Optional<Book> savedBook = Optional.empty();
        if (book.getAuthor() != null &&
                authorService.findById(book.getAuthor().getId()).isPresent()) {
            savedBook = Optional.of(
                        bookRepository.save(new Book(
                                book.getName(),
                                Category.valueOf(book.getCategory().name().toUpperCase()), // Конверзија од String во Enum
                                authorService.findById(book.getAuthor().getId()).get(),  //go zema objektot Author
                                book.getAvailableCopies())
                        ));
//            this.refreshMaterializedView();
        }
        return savedBook;
    }


    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> update(Long id, Book book) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    if(book.getName() != null) {
                        existingBook.setName(book.getName());
                    }
                    if (book.getCategory() != null) {
                        existingBook.setCategory(Category.valueOf(book.getCategory().name().toUpperCase()));
                    }
                    if (book.getAvailableCopies() != null) {
                        existingBook.setAvailableCopies(book.getAvailableCopies());
                    }
                    if (book.getAuthor() != null && authorService.findById(book.getAuthor().getId()).isPresent()) {
                        existingBook.setAuthor(authorService.findById(book.getAuthor().getId()).get());
                    }
                    return bookRepository.save(existingBook);
                });
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Book> rentBook(Long id) {
        Optional<Book> b = bookRepository.findById(id);
        if(!b.isPresent()){
            throw new RuntimeException("book not found");
        }
        Book book = b.get();
        if(book.getAvailableCopies()<=0){
            throw new RuntimeException("not enough books");
        }
        book.setAvailableCopies(book.getAvailableCopies()-1);
        bookRepository.save(book);
        return Optional.of(book);
    }


    @Override
    public Optional<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public void refreshMaterializedView() {
        booksPerAuthorViewRepository.refreshMaterializedView();
    }

    @Override
    public List<Book> findByCategory(Category category) {
        return bookRepository.findByCategory(category);
    }

    @Override
    public List<Book> getAvailableBooks() {
        return bookRepository.findByAvailableCopiesGreaterThan(0);
    }

//    @Override
//    public Book findByTitleAndAuthor(String name, Author author) {
//        return bookRepository.findByTitleAndAuthor(name, author);
//    }


}
