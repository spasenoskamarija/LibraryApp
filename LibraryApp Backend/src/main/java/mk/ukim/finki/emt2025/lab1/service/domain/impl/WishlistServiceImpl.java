package mk.ukim.finki.emt2025.lab1.service.domain.impl;

import mk.ukim.finki.emt2025.lab1.dto.WishlistDto;
import mk.ukim.finki.emt2025.lab1.model.domain.Book;
import mk.ukim.finki.emt2025.lab1.model.domain.Wishlist;
import mk.ukim.finki.emt2025.lab1.repository.WishlistRepository;
import mk.ukim.finki.emt2025.lab1.service.domain.BookService;
import mk.ukim.finki.emt2025.lab1.service.domain.UserService;
import mk.ukim.finki.emt2025.lab1.service.domain.WishlistService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishlistRepository;
    private final BookService bookService;
    private final UserService userService;

    public WishlistServiceImpl(WishlistRepository wishlistRepository, BookService bookService, UserService userService) {
        this.wishlistRepository = wishlistRepository;
        this.bookService = bookService;
        this.userService = userService;
    }

    @Override
    public Optional<Wishlist> findWishListByUsername(String username) {
        return wishlistRepository.findWishlistByUserUsername(username);
    }

    @Override
    public Wishlist addBookToWishList(String username, Long bookId) {
        Wishlist wishlist = wishlistRepository.findWishlistByUserUsername(username)
                .orElseGet(() -> wishlistRepository.save(new Wishlist(userService.findByUsername(username))));

        Book book = bookService.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getAvailableCopies() > 0 && !wishlist.getBooks().contains(book)) {
            wishlist.getBooks().add(book);
            return wishlistRepository.save(wishlist);
        } else {
            throw new RuntimeException("Book is not available or already in wishlist");
        }
    }

    @Override
    public void rentAllBooksFromWishlist(String username) {
        Wishlist wishlist = wishlistRepository.findWishlistByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("Wishlist not found"));

        for (Book book : wishlist.getBooks()) {
            if (book.getAvailableCopies() > 0) {
                book.setAvailableCopies(book.getAvailableCopies() - 1);
            } else {
                throw new RuntimeException("Book " + book.getName() + " is not available for rent");
            }
        }
        wishlist.getBooks().clear();
        wishlistRepository.save(wishlist);
    }

    @Override
    public void deleteByUsername(String username) {
        wishlistRepository.deleteByUserUsername(username);
    }

}
