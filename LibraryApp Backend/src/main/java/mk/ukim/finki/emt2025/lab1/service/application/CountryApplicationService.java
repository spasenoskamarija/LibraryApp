package mk.ukim.finki.emt2025.lab1.service.application;

import mk.ukim.finki.emt2025.lab1.dto.CreateBookDto;
import mk.ukim.finki.emt2025.lab1.dto.CreateCountryDto;
import mk.ukim.finki.emt2025.lab1.dto.UpdateCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    List<UpdateCountryDto> getCountries();
    Optional<UpdateCountryDto> getCountryById(Long id);
    Optional<UpdateCountryDto> create(CreateCountryDto createCountryDto);
    Optional<UpdateCountryDto> update(Long id, CreateCountryDto createCountryDto);
    void delete(Long id);
}
