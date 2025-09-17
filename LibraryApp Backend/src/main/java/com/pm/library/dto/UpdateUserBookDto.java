package com.pm.library.dto;

import com.pm.library.model.domain.UserBooks;

import java.util.List;
import java.util.stream.Collectors;

public record UpdateUserBookDto(Long id, Long bookId, String username) {

    public static UpdateUserBookDto from(UserBooks userbook) {
        return new UpdateUserBookDto(userbook.getId(), userbook.getBookId(), userbook.getUsername());
    }

    public static List<UpdateUserBookDto> from(List<UserBooks> userbooks) {
        return userbooks.stream().map(UpdateUserBookDto::from).collect(Collectors.toList());
    }
}
