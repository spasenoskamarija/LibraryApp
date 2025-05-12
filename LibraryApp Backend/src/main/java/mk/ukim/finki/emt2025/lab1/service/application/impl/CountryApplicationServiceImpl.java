package mk.ukim.finki.emt2025.lab1.service.application.impl;

import mk.ukim.finki.emt2025.lab1.dto.CreateCountryDto;
import mk.ukim.finki.emt2025.lab1.dto.UpdateCountryDto;
import mk.ukim.finki.emt2025.lab1.service.application.CountryApplicationService;
import mk.ukim.finki.emt2025.lab1.service.domain.CountryService;
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
