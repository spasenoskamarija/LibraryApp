package mk.ukim.finki.emt2025.lab1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BooksPerAuthorDto {
    private Long authorId;
    private Integer numBooks;

    public BooksPerAuthorDto() {
    }

    public BooksPerAuthorDto(Long authorId, Integer numBooks) {
        this.authorId = authorId;
        this.numBooks = numBooks;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Integer getNumBooks() {
        return numBooks;
    }
}