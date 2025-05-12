package mk.ukim.finki.emt2025.lab1.web;


import mk.ukim.finki.emt2025.lab1.dto.CreateCountryDto;
import mk.ukim.finki.emt2025.lab1.dto.UpdateCountryDto;
import mk.ukim.finki.emt2025.lab1.service.application.CountryApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3003")
@RestController
@RequestMapping("/api/countries")
public class CountryRestController {
    private final CountryApplicationService countryApplicationService;

    public CountryRestController(CountryApplicationService countryApplicationService) {
        this.countryApplicationService = countryApplicationService;
    }

    @GetMapping
    public List<UpdateCountryDto> findAll() {
        return countryApplicationService.getCountries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UpdateCountryDto> findById(@PathVariable Long id) {
        return countryApplicationService.getCountryById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<UpdateCountryDto> save(@RequestBody CreateCountryDto createCountryDto) {
        return countryApplicationService.create(createCountryDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")  //moze i PatchMapping
    public ResponseEntity<UpdateCountryDto> update(@PathVariable Long id, @RequestBody CreateCountryDto createCountryDto) {
        return countryApplicationService.update(id, createCountryDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (countryApplicationService.getCountryById(id).isPresent()) {
            countryApplicationService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
