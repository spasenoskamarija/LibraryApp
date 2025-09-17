package com.pm.library.service.application;

import com.pm.library.dto.CreateAuthorDto;
import com.pm.library.dto.UpdateAuthorDto;

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
