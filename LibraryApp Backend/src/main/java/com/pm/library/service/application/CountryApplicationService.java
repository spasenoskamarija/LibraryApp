package com.pm.library.service.application;

import com.pm.library.dto.CreateCountryDto;
import com.pm.library.dto.UpdateCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    List<UpdateCountryDto> getCountries();
    Optional<UpdateCountryDto> getCountryById(Long id);
    Optional<UpdateCountryDto> create(CreateCountryDto createCountryDto);
    Optional<UpdateCountryDto> update(Long id, CreateCountryDto createCountryDto);
    void delete(Long id);
}
