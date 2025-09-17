package com.pm.library.dto;

import com.pm.library.model.domain.Role;
import com.pm.library.model.domain.User;

public record CreateUserDto(
        String username,
        String password,
        String repeatPassword,
        String name,
        String surname,
        Role role
) {

    /*
        todo: add repeat password logic
     */
    public User toUser() {
        return new User(username, password, name, surname, role);
    }
}
