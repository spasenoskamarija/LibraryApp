package mk.ukim.finki.emt2025.lab1.dto;

import mk.ukim.finki.emt2025.lab1.model.domain.Country;

import java.util.List;
import java.util.stream.Collectors;

public record UpdateCountryDto(Long id,String name, String continent) {
    public static UpdateCountryDto from(Country country) {
        return new UpdateCountryDto(country.getId(), country.getName(), country.getContinent());
    }

    public Country toAuthor() {
        return new Country(name,continent);
    }

    public static List<UpdateCountryDto> from(List<Country> countries) {
        return countries
                .stream()
                .map(UpdateCountryDto::from)
                .collect(Collectors.toList());
    }
}
