package com.pm.library.service.application.impl;

import com.pm.library.dto.CreateAuthorDto;
import com.pm.library.dto.UpdateAuthorDto;
import com.pm.library.model.domain.Country;
import com.pm.library.service.application.AuthorApplicationService;
import com.pm.library.service.domain.AuthorService;
import com.pm.library.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorApplicationServiceImpl implements AuthorApplicationService {

    private final AuthorService authorService;
    private final CountryService countryService;

    public AuthorApplicationServiceImpl(AuthorService authorService, CountryService countryService) {
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @Override
    public List<UpdateAuthorDto> getAuthors() {
        return UpdateAuthorDto.from(authorService.findAll());
    }

    @Override
    public Optional<UpdateAuthorDto> getAuthorById(Long id) {
        return authorService.findById(id).map(UpdateAuthorDto::from);
    }

    @Override
    public Optional<UpdateAuthorDto> create(CreateAuthorDto createAuthorDto) {
        Optional<Country> country = countryService.findById(createAuthorDto.countryId());

        if (country.isPresent()) {
            return authorService.save(createAuthorDto.toAuthor(country.get()))
                    .map(UpdateAuthorDto::from);
        }
        return Optional.empty();

    }

    @Override
    public Optional<UpdateAuthorDto> update(Long id, CreateAuthorDto createAuthorDto) {
        Optional<Country> country = countryService.findById(createAuthorDto.countryId());

        return authorService.update(id,createAuthorDto.toAuthor(country.get())).map(UpdateAuthorDto::from);
    }

    @Override
    public void delete(Long id) {
        authorService.deleteById(id);
    }

    @Override
    public List<UpdateAuthorDto> findAllAuthorsByCountry(Long countryId) {
        return UpdateAuthorDto.from(authorService.findAllAuthorsByCountry(countryId));
    }
}
