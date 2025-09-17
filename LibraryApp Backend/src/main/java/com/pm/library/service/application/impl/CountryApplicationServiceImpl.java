package com.pm.library.service.application.impl;

import com.pm.library.dto.CreateCountryDto;
import com.pm.library.dto.UpdateCountryDto;
import com.pm.library.service.application.CountryApplicationService;
import com.pm.library.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {

    private final CountryService countryService;

    public CountryApplicationServiceImpl(CountryService countryService) {
        this.countryService = countryService;
    }


    @Override
    public List<UpdateCountryDto> getCountries() {
        return UpdateCountryDto.from(countryService.findAll());
    }

    @Override
    public Optional<UpdateCountryDto> getCountryById(Long id) {
        return countryService.findById(id).map(UpdateCountryDto::from);
    }

    @Override
    public Optional<UpdateCountryDto> create(CreateCountryDto createCountryDto) {
        return countryService.save(createCountryDto.toCountry()).map(UpdateCountryDto::from);
    }

    @Override
    public Optional<UpdateCountryDto> update(Long id, CreateCountryDto createCountryDto) {
        return countryService.update(id, createCountryDto.toCountry()).map(UpdateCountryDto::from);
    }

    @Override
    public void delete(Long id) {
        countryService.deleteById(id);
    }
}
