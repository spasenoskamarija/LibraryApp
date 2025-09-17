package com.pm.library.repository;

import jakarta.transaction.Transactional;
import com.pm.library.model.domain.Book;
import com.pm.library.model.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String name);

    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.availableCopies = b.availableCopies - 1 WHERE b.id = :id AND b.availableCopies > 0")
    int rentBook(@Param("id") Long id);

    List<Book> findByCategory(Category category);

    List<Book> findByAvailableCopiesGreaterThan(int value);

}
