package mk.ukim.finki.emt2025.lab1.repository;

import mk.ukim.finki.emt2025.lab1.model.domain.UserBooks;
import mk.ukim.finki.emt2025.lab1.model.domain.User;
import mk.ukim.finki.emt2025.lab1.model.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface UserBooksRepository extends JpaRepository<UserBooks, Long> {
    // Наоѓа сите UserBooks записи за дадена книга
    List<UserBooks> findByBookId(Long bookId);

    @Query("SELECT ub.bookId FROM UserBooks ub GROUP BY ub.bookId ORDER BY COUNT(ub.bookId) DESC LIMIT 1")
    Long findMostRentedBook();

    @Query("SELECT ub.username FROM UserBooks ub JOIN Author a ORDER BY COUNT(a.name)")
    Author findMostRentedAuthor();

    @Query("SELECT ub.username FROM UserBooks ub GROUP BY ub.username ORDER BY COUNT(ub.username) DESC LIMIT 1")
    String findMostActiveUser();

}
