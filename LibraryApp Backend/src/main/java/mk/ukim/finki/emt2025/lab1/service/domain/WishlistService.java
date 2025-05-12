package mk.ukim.finki.emt2025.lab1.service.domain;

import mk.ukim.finki.emt2025.lab1.model.domain.Book;
import mk.ukim.finki.emt2025.lab1.model.domain.Wishlist;

import java.util.List;
import java.util.Optional;

public interface WishlistService {
    Optional<Wishlist> findWishListByUsername(String username);
    Wishlist addBookToWishList(String username, Long bookId);
    void rentAllBooksFromWishlist(String username);
    void deleteByUsername(String username);
}
