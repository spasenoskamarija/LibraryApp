package mk.ukim.finki.emt2025.lab1.dto;

import mk.ukim.finki.emt2025.lab1.model.domain.Role;
import mk.ukim.finki.emt2025.lab1.model.domain.User;

public record UpdateUserDto(String username, String name, String surname, Role role) {

    public static UpdateUserDto from(User user) {
        return new UpdateUserDto(
                user.getUsername(),
                user.getName(),
                user.getSurname(),
                user.getRole()
        );
    }

    public User toUser() {
        return new User(username, name, surname, role.name());
    }
}

