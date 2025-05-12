package mk.ukim.finki.emt2025.lab1.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emt2025.lab1.model.domain.*;
import mk.ukim.finki.emt2025.lab1.repository.AuthorRepository;
import mk.ukim.finki.emt2025.lab1.repository.BookRepository;
import mk.ukim.finki.emt2025.lab1.repository.CountryRepository;
import mk.ukim.finki.emt2025.lab1.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public DataInitializer(CountryRepository countryRepository, AuthorRepository authorRepository, BookRepository bookRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    @PostConstruct
    public void init() {
        Country macedonia = countryRepository.save(new Country("Macedonia", "Europe"));
        Country usa = countryRepository.save(new Country("USA", "North America"));
        Country france = countryRepository.save(new Country("France", "Europe"));
        Country japan = countryRepository.save(new Country("Japan", "Asia"));
        Country brazil = countryRepository.save(new Country("Brazil", "South America"));

        // Зачувување на автори
        Author petre = authorRepository.save(new Author("Petre", "Andreevski", macedonia));
        Author mark = authorRepository.save(new Author("Mark", "Twain", usa));
        Author victor = authorRepository.save(new Author("Victor", "Hugo", france));
        Author haruki = authorRepository.save(new Author("Haruki", "Murakami", japan));
        Author paulo = authorRepository.save(new Author("Paulo", "Coelho", brazil));

        // Зачувување на книги
        bookRepository.save(new Book("Pirej", Category.NOVEL, petre, 5));
        bookRepository.save(new Book("Tom Sawyer", Category.HISTORY, mark, 3));
        bookRepository.save(new Book("Les Misérables", Category.DRAMA, victor, 2));
        bookRepository.save(new Book("Norwegian Wood", Category.FANTASY, haruki , 4));
        bookRepository.save(new Book("The Alchemist", Category.
                CLASSICS, paulo, 6));

        userRepository.save(new User(
                "user",
                passwordEncoder.encode("user"),
                "user",
                "user",
                Role.USER
        ));

        userRepository.save(new User(
                "ms",
                passwordEncoder.encode("ms"),
                "Marija",
                "Spasenoska",
                Role.LIBRARIAN
        ));

    }
}
