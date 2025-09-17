package com.pm.library.dto;

import lombok.Data;

@Data
public class AuthorsPerCountryDto {
    private Long countryId;
    private String countryName;
    private Integer numAuthors;

    public AuthorsPerCountryDto() {
    }

    public AuthorsPerCountryDto(Long countryId, Integer numAuthors) {
        this.countryId = countryId;
        this.numAuthors = numAuthors;
    }

    public AuthorsPerCountryDto(String countryName, Integer numAuthors) {
        this.countryName = countryName;
        this.numAuthors = numAuthors;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Integer getNumAuthors() {
        return numAuthors;
    }

    public String getCountryName() {
        return countryName;
    }
}
