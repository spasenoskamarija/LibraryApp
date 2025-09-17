package com.pm.library.dto;

import com.pm.library.model.domain.Wishlist;

import java.util.List;

public record WishlistDto(Long id, UpdateUserDto userDto, List<UpdateBookDto> bookDtoList) {
    public static WishlistDto from(Wishlist wishlist) {
        return new WishlistDto(
                wishlist.getId(),
                UpdateUserDto.from(wishlist.getUser()),
                UpdateBookDto.from(wishlist.getBooks())
        );
    }
}
