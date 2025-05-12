package mk.ukim.finki.emt2025.lab1.service.application;

import mk.ukim.finki.emt2025.lab1.dto.CreateAuthorDto;
import mk.ukim.finki.emt2025.lab1.dto.CreateBookDto;
import mk.ukim.finki.emt2025.lab1.dto.UpdateBookDto;
import mk.ukim.finki.emt2025.lab1.model.domain.Category;

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
