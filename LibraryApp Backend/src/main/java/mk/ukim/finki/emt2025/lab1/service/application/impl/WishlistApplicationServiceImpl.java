package mk.ukim.finki.emt2025.lab1.service.application.impl;

import mk.ukim.finki.emt2025.lab1.dto.WishlistDto;
import mk.ukim.finki.emt2025.lab1.model.domain.Book;
import mk.ukim.finki.emt2025.lab1.model.domain.Wishlist;
import mk.ukim.finki.emt2025.lab1.service.application.WishlistApplicationService;
import mk.ukim.finki.emt2025.lab1.service.domain.WishlistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
