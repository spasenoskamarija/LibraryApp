package com.pm.library.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.pm.library.dto.WishlistDto;
import com.pm.library.service.application.WishlistApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/wishlist")
@Tag(name = "Wishlist API", description = "Endpoints for managing user wishlists")
public class WishlistRestController {
    private final WishlistApplicationService wishlistApplicationService;


    public WishlistRestController(WishlistApplicationService wishlistApplicationService) {
        this.wishlistApplicationService = wishlistApplicationService;
    }

    @Operation(summary = "Get wishlist by username", description = "Retrieves the wishlist for a given username.")
    @GetMapping
    public Optional<WishlistDto> findWishlistByUsername(@RequestParam String username) {
        return wishlistApplicationService.findWishListByUsername(username);
    }

    @Operation(summary = "Add book to wishlist", description = "Add a book to the user's wishlist.")
    @PostMapping("/add/{bookId}")
    public ResponseEntity<WishlistDto> addBookToWishlist(@PathVariable Long bookId, @RequestParam String username) {
        try {
            return ResponseEntity.ok(wishlistApplicationService.addBookToWishList(username, bookId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Operation(summary = "Rent a book", description = "Decreases the number of available copies if possible.")
    @PostMapping("/rent")
    public ResponseEntity<String> rentWishListBooks(@RequestParam String username) {
        try {
            wishlistApplicationService.rentAllBooksFromWishlist(username);
            return ResponseEntity.ok("All books from the wishlist have been rented successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Delete wishlist", description = "Delete all books from the user's wishlist.")
    @DeleteMapping("/delete")
    public void deleteWishlistBooks(@RequestParam String username) {
        wishlistApplicationService.deleteByUsername(username);
    }

}
