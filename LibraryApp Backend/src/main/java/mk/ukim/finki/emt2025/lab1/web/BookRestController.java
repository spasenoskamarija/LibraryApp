package mk.ukim.finki.emt2025.lab1.web;

import io.swagger.v3.oas.annotations.Operation;
import mk.ukim.finki.emt2025.lab1.dto.BooksPerAuthorDto;
import mk.ukim.finki.emt2025.lab1.dto.CreateBookDto;
import mk.ukim.finki.emt2025.lab1.dto.UpdateBookDto;
import mk.ukim.finki.emt2025.lab1.model.domain.Author;
import mk.ukim.finki.emt2025.lab1.model.domain.Book;
import mk.ukim.finki.emt2025.lab1.model.domain.Category;
import mk.ukim.finki.emt2025.lab1.model.domain.UserBooks;
import mk.ukim.finki.emt2025.lab1.model.views.BooksPerAuthorView;
import mk.ukim.finki.emt2025.lab1.repository.AuthorRepository;
import mk.ukim.finki.emt2025.lab1.repository.views.AuthorsPerCountryViewRepository;
import mk.ukim.finki.emt2025.lab1.repository.views.BooksPerAuthorViewRepository;
import mk.ukim.finki.emt2025.lab1.service.application.BookApplicationService;
import mk.ukim.finki.emt2025.lab1.service.domain.UserBooksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3003")
@RestController
@RequestMapping("/api/books")
public class BookRestController {
    private final BookApplicationService bookApplicationService;
    private final UserBooksService userBooksService;
    private final BooksPerAuthorViewRepository booksPerAuthorViewRepository;
    private final AuthorsPerCountryViewRepository authorsPerCountryViewRepository;
    private final AuthorRepository authorRepository;



    public BookRestController(BookApplicationService bookApplicationService, UserBooksService userBooksService, BooksPerAuthorViewRepository booksPerAuthorViewRepository, AuthorsPerCountryViewRepository authorsPerCountryViewRepository, AuthorRepository authorRepository) {
        this.bookApplicationService = bookApplicationService;
        this.userBooksService = userBooksService;
        this.booksPerAuthorViewRepository = booksPerAuthorViewRepository;
        this.authorsPerCountryViewRepository = authorsPerCountryViewRepository;
        this.authorRepository = authorRepository;
    }

    @Operation(summary = "Get all books", description = "Retrieves a list of all available books in the system.")
    @GetMapping
    public List<UpdateBookDto> findAll() {
        return bookApplicationService.getBooks();
    }

    @Operation(summary = "Get a book by ID", description = "Fetches details of a specific book based on the given ID.")
    @GetMapping("/{id}")
    public ResponseEntity<UpdateBookDto> findById(@PathVariable Long id) {
        return bookApplicationService.getBookById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Add a new book", description = "Creates a new book entry. Only accessible by users with the 'LIBRARIAN' role.")
    @PostMapping("/add")
    public ResponseEntity<UpdateBookDto> save(@RequestBody CreateBookDto bookDto) {
        return bookApplicationService.create(bookDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update a book", description = "Updates details of an existing book based on the given ID.")
    @PutMapping("/edit/{id}")  //moze i PatchMapping
    public ResponseEntity<UpdateBookDto> update(@PathVariable Long id, @RequestBody CreateBookDto bookDto) {
        return bookApplicationService.update(id, bookDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a book", description = "Deletes a book entry by its ID.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (bookApplicationService.getBookById(id).isPresent()) {
            bookApplicationService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Rent a book for a user", description = "Assigns a book to a user, marking it as rented.")
    @PostMapping("/rent_userbook/{id}")
    public ResponseEntity<UserBooks> saveUserBook(@PathVariable Long id, String username) {
        return this.userBooksService.rentUserBooks(id, username)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/find/{id}")
    public List<UserBooks> findUserBooksByBookId(@PathVariable Long id) {
        return this.userBooksService.findAllByBookId(id);
    }

    @GetMapping("/most-rented-book")
    Optional<Book> findMostRentedBook(){
        return this.userBooksService.findMostRentedBook();
    }

    @GetMapping("/most-rented-author")
    Optional<Author> findMostRentedAuthor(){
        return this.userBooksService.findMostRentedAuthor();
    }

    @GetMapping("/most-active-user")
    public Optional<String> findMostActiveUser() {
        return userBooksService.findMostActiveUser();
    }

//    //Baranje 3
//    @Operation(summary = "Get number of books per author", description = "Materialized view, refresh scheduled.")
//    @GetMapping("/by-author")
//    public List<BooksPerAuthorView> getBooksPerAuthor() {
//        return booksPerAuthorViewRepository.findAll();
//    }

    @GetMapping("/by-author")
    public List<BooksPerAuthorDto> getBooksPerAuthor() {
        return booksPerAuthorViewRepository.findAll()
                .stream()
                .map(view -> new BooksPerAuthorDto(
                        view.getAuthorId(),
                        view.getNumBooks()
                ))
                .toList();
    }

    //Site dostapni knigi kade nivnite availableCopies se pogolemi od 0
    @GetMapping("/available")
    public List<UpdateBookDto> getAvailableBooks() {
        return bookApplicationService.getAvailableBooks();
    }

    @GetMapping("/category")
    public List<UpdateBookDto> findByCategory(@RequestParam Category category) {
        return bookApplicationService.findByCategory(category);
    }


}
