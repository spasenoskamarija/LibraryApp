package mk.ukim.finki.emt2025.lab1.web;


import io.swagger.v3.oas.annotations.Operation;
import mk.ukim.finki.emt2025.lab1.dto.CreateAuthorDto;
import mk.ukim.finki.emt2025.lab1.dto.CreateBookDto;
import mk.ukim.finki.emt2025.lab1.dto.UpdateAuthorDto;
import mk.ukim.finki.emt2025.lab1.dto.UpdateBookDto;
import mk.ukim.finki.emt2025.lab1.model.domain.Author;
import mk.ukim.finki.emt2025.lab1.model.projections.AuthorNameProjection;
import mk.ukim.finki.emt2025.lab1.model.views.AuthorsPerCountryView;
import mk.ukim.finki.emt2025.lab1.repository.AuthorRepository;
import mk.ukim.finki.emt2025.lab1.repository.views.AuthorsPerCountryViewRepository;
import mk.ukim.finki.emt2025.lab1.service.application.AuthorApplicationService;
import mk.ukim.finki.emt2025.lab1.service.domain.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3003")
@RestController
@RequestMapping("/api/authors")
public class AuthorRestController {
    private final AuthorApplicationService authorApplicationService;
    private final AuthorsPerCountryViewRepository authorsPerCountryViewRepository;
    private final AuthorRepository authorRepository;

    public AuthorRestController(AuthorApplicationService authorApplicationService, AuthorsPerCountryViewRepository authorsPerCountryViewRepository, AuthorRepository authorRepository) {
        this.authorApplicationService = authorApplicationService;
        this.authorsPerCountryViewRepository = authorsPerCountryViewRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public List<UpdateAuthorDto> findAll() {
        return authorApplicationService.getAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UpdateAuthorDto> findById(@PathVariable Long id) {
        return authorApplicationService.getAuthorById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<UpdateAuthorDto> save(@RequestBody CreateAuthorDto authorDto) {
        return authorApplicationService.create(authorDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")  //moze i PatchMapping
    public ResponseEntity<UpdateAuthorDto> update(@PathVariable Long id, @RequestBody CreateAuthorDto authorDto) {
        return authorApplicationService.update(id, authorDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (authorApplicationService.getAuthorById(id).isPresent()) {
            authorApplicationService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    //Baranje 4
    @Operation(summary = "Get number of authors per country", description = "Materialized view, refreshed on author changes.")
    @GetMapping("/by-country")
    public List<AuthorsPerCountryView> getAuthorsPerCountry() {
        return authorsPerCountryViewRepository.findAll();
    }

    //Baranje 5
    @Operation(summary = "Get author names", description = "Returns only name and surname using projection.")
    @GetMapping("/names")
    public List<AuthorNameProjection> getAuthorNames() {
        return authorRepository.findAllBy();
    }


    @GetMapping("/findBy-countryId")
    public List<UpdateAuthorDto> getAuthorsByCountry(@RequestParam Long countryId) {
        return authorApplicationService.findAllAuthorsByCountry(countryId);
    }
}
