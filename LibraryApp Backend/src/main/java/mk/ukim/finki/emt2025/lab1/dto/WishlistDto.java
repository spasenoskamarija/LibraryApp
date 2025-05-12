package mk.ukim.finki.emt2025.lab1.dto;

import mk.ukim.finki.emt2025.lab1.model.domain.Wishlist;

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
