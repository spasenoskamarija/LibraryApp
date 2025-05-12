package mk.ukim.finki.emt2025.lab1.dto;

import mk.ukim.finki.emt2025.lab1.model.domain.UserBooks;

public record CreateUserBookDto(Long bookId, String username) {
    public UserBooks toUserBook() {
        return new UserBooks(bookId, username);
    }

}
