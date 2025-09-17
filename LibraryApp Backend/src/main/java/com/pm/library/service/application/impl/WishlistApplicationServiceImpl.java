package com.pm.library.service.application.impl;

import com.pm.library.dto.WishlistDto;
import com.pm.library.service.application.WishlistApplicationService;
import com.pm.library.service.domain.WishlistService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WishlistApplicationServiceImpl implements WishlistApplicationService {

    private final WishlistService wishlistService;

    public WishlistApplicationServiceImpl(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @Override
    public Optional<WishlistDto> findWishListByUsername(String username) {
        return wishlistService.findWishListByUsername(username)
                .map(WishlistDto::from);
    }

    @Override
    public WishlistDto addBookToWishList(String username, Long bookId) {
        return WishlistDto.from(wishlistService.addBookToWishList(username, bookId));
    }

    @Override
    public void rentAllBooksFromWishlist(String username) {
        wishlistService.rentAllBooksFromWishlist(username);

    }

    @Override
    public void deleteByUsername(String username) {
        wishlistService.deleteByUsername(username);
    }



}
