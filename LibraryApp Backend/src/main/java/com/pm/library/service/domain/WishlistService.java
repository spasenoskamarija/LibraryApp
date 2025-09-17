package com.pm.library.service.domain;

import com.pm.library.model.domain.Wishlist;

import java.util.Optional;

public interface WishlistService {
    Optional<Wishlist> findWishListByUsername(String username);
    Wishlist addBookToWishList(String username, Long bookId);
    void rentAllBooksFromWishlist(String username);
    void deleteByUsername(String username);
}
