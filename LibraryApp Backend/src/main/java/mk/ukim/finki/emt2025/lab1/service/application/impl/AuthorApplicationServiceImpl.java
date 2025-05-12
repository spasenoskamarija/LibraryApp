package mk.ukim.finki.emt2025.lab1.service.application.impl;

import mk.ukim.finki.emt2025.lab1.dto.CreateAuthorDto;
import mk.ukim.finki.emt2025.lab1.dto.UpdateAuthorDto;
import mk.ukim.finki.emt2025.lab1.model.domain.Author;
import mk.ukim.finki.emt2025.lab1.model.domain.Country;
import mk.ukim.finki.emt2025.lab1.service.application.AuthorApplicationService;
import mk.ukim.finki.emt2025.lab1.service.domain.AuthorService;
import mk.ukim.finki.emt2025.lab1.service.domain.CountryService;
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
