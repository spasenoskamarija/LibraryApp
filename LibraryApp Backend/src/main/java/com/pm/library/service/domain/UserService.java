package com.pm.library.service.domain;

import com.pm.library.model.domain.Role;
import com.pm.library.model.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User login(String username, String password);

    User findByUsername(String username);

    List<User> findAll();

}
