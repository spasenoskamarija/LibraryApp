package com.pm.library.service.application;

import com.pm.library.dto.CreateBookDto;
import com.pm.library.dto.UpdateBookDto;
import com.pm.library.model.domain.Category;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {
    List<UpdateBookDto> getBooks();
    Optional<UpdateBookDto> getBookById(Long id);
    Optional<UpdateBookDto> create(CreateBookDto createBookDto);
    Optional<UpdateBookDto> update(Long id, CreateBookDto createBookDto);
    void delete(Long id);
    List<UpdateBookDto> findByCategory(Category category);
    List<UpdateBookDto> getAvailableBooks();
}
