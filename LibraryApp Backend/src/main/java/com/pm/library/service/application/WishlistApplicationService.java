package com.pm.library.service.application;

import com.pm.library.dto.WishlistDto;

import java.util.Optional;

public interface WishlistApplicationService {
    Optional<WishlistDto> findWishListByUsername(String username);
    WishlistDto addBookToWishList(String username, Long bookId);
    void rentAllBooksFromWishlist(String username);
    void deleteByUsername(String username);
}
