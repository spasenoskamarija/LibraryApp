package mk.ukim.finki.emt2025.lab1.service.domain.impl;

import mk.ukim.finki.emt2025.lab1.model.domain.Author;
import mk.ukim.finki.emt2025.lab1.model.domain.Book;
import mk.ukim.finki.emt2025.lab1.model.domain.User;
import mk.ukim.finki.emt2025.lab1.model.domain.UserBooks;
import mk.ukim.finki.emt2025.lab1.repository.AuthorRepository;
import mk.ukim.finki.emt2025.lab1.repository.BookRepository;
import mk.ukim.finki.emt2025.lab1.repository.UserBooksRepository;
import mk.ukim.finki.emt2025.lab1.repository.UserRepository;
import mk.ukim.finki.emt2025.lab1.service.domain.UserBooksService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserBooksServiceImpl implements UserBooksService {

    private final UserBooksRepository userBooksRepository;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public UserBooksServiceImpl(UserBooksRepository userBooksRepository, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.userBooksRepository = userBooksRepository;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<UserBooks> rentUserBooks(Long bookId, String username) {
       Book book = bookRepository.findById(bookId).orElseThrow(()->new RuntimeException("Book not found"));
       //dokolku bookId postoi proveri dali imaa povekje od 0 kopii za da moze da napali za 1 i napravi save vo baza
       if(bookId!=null){
           if(book.getAvailableCopies() > 0){
               book.setAvailableCopies(book.getAvailableCopies() - 1);
               bookRepository.save(book);
               return Optional.of(
                       userBooksRepository.save(new UserBooks(
                                       bookId,
                                       username
                               )
                       )
               );
           }
       }
        return Optional.empty();
    }

    @Override
    public List<UserBooks> findAllByBookId(Long bookId) {
        if (userBooksRepository.findById(bookId).isPresent()) {
           return userBooksRepository.findByBookId(bookId);
        }
        return null;
    }

    @Override
    public Optional<Book> findMostRentedBook() {
        Long bookId = userBooksRepository.findMostRentedBook();
        if (bookId != null)
            return bookRepository.findById(bookId);
        return Optional.empty();
    }

    @Override
    public Optional<Author> findMostRentedAuthor() {
        Long authorId = userBooksRepository.findMostRentedBook();
        if (authorId != null){
            return authorRepository.findById(authorId);
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> findMostActiveUser() {
        String username = userBooksRepository.findMostActiveUser();
        return Optional.ofNullable(username);
    }
}
