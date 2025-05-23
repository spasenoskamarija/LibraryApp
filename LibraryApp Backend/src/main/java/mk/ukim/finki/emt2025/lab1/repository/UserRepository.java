package mk.ukim.finki.emt2025.lab1.repository;

import mk.ukim.finki.emt2025.lab1.model.domain.Role;
import mk.ukim.finki.emt2025.lab1.model.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(
            type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"username", "password", "name", "surname", "role", "isAccountNonExpired", "isAccountNonLocked", "isCredentialsNonExpired", "isEnabled"}
    )
    @Query("select u from User u")
    List<User> findAll();

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);
}
