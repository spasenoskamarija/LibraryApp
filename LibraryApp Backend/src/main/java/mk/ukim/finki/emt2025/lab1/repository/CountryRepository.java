package mk.ukim.finki.emt2025.lab1.repository;

import mk.ukim.finki.emt2025.lab1.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
