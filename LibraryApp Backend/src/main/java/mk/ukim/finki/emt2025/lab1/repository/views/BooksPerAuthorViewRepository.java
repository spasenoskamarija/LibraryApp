package mk.ukim.finki.emt2025.lab1.repository.views;

import mk.ukim.finki.emt2025.lab1.model.views.BooksPerAuthorView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BooksPerAuthorViewRepository extends JpaRepository<BooksPerAuthorView, Long> {
    @Transactional
    @Modifying
    @Query(value = "REFRESH MATERIALIZED VIEW books_per_author", nativeQuery = true)
    void refreshMaterializedView();
}

