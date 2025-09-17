package com.pm.library.repository;

import com.pm.library.model.domain.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Optional<Wishlist> findWishlistByUserUsername(String username);
    void deleteByUserUsername(String username);
}
