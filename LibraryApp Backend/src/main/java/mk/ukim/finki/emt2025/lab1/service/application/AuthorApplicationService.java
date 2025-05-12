package mk.ukim.finki.emt2025.lab1.service.application;

import mk.ukim.finki.emt2025.lab1.dto.CreateAuthorDto;
import mk.ukim.finki.emt2025.lab1.dto.UpdateAuthorDto;
import mk.ukim.finki.emt2025.lab1.model.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorApplicationService {
    List<UpdateAuthorDto> getAuthors();
    Optional<UpdateAuthorDto> getAuthorById(Long id);
    Optional<UpdateAuthorDto> create(CreateAuthorDto createAuthorDto);
    Optional<UpdateAuthorDto> update(Long id, CreateAuthorDto createAuthorDto);
    void delete(Long id);
    List<UpdateAuthorDto> findAllAuthorsByCountry(Long countryId);
}
