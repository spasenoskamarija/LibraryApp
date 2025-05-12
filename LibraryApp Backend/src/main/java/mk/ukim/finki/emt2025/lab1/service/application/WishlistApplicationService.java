package mk.ukim.finki.emt2025.lab1.service.application;

import mk.ukim.finki.emt2025.lab1.dto.WishlistDto;
import mk.ukim.finki.emt2025.lab1.model.domain.Book;
import mk.ukim.finki.emt2025.lab1.model.domain.Wishlist;

import java.util.List;
import java.util.Optional;

public interface WishlistApplicationService {
    Optional<WishlistDto> findWishListByUsername(String username);
    WishlistDto addBookToWishList(String username, Long bookId);
    void rentAllBooksFromWishlist(String username);
    void deleteByUsername(String username);
}
