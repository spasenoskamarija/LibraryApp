package mk.ukim.finki.emt2025.lab1.repository;

import mk.ukim.finki.emt2025.lab1.model.domain.Author;
import mk.ukim.finki.emt2025.lab1.model.projections.AuthorNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<AuthorNameProjection> findAllBy();
    List<Author> findAllByCountryId(Long countryId);
}
