package mk.ukim.finki.emt2025.lab1.model.views;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
@Entity
@Subselect("SELECT * FROM authors_per_country")
@Immutable
public class AuthorsPerCountryView {
    @Id
    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "num_authors")
    private Integer numAuthors;

    public AuthorsPerCountryView() {
    }

    public AuthorsPerCountryView(Long countryId, Integer numAuthors) {
        this.countryId = countryId;
        this.numAuthors = numAuthors;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Integer getNumAuthors() {
        return numAuthors;
    }
}
