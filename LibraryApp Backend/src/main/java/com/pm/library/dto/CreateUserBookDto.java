package com.pm.library.dto;

import com.pm.library.model.domain.UserBooks;

public record CreateUserBookDto(Long bookId, String username) {
    public UserBooks toUserBook() {
        return new UserBooks(bookId, username);
    }

}
