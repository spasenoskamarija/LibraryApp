package mk.ukim.finki.emt2025.lab1.service.domain;

import mk.ukim.finki.emt2025.lab1.dto.UpdateUserDto;
import mk.ukim.finki.emt2025.lab1.model.domain.Role;
import mk.ukim.finki.emt2025.lab1.model.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User login(String username, String password);

    User findByUsername(String username);

    List<User> findAll();

}
