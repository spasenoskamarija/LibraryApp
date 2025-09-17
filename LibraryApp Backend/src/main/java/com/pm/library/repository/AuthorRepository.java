package com.pm.library.repository;

import com.pm.library.model.domain.Author;
import com.pm.library.model.projections.AuthorNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<AuthorNameProjection> findAllBy();
    List<Author> findAllByCountryId(Long countryId);
}
