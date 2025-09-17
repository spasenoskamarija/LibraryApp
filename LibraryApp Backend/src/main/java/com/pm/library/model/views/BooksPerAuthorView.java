package com.pm.library.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
@Entity
@Subselect("SELECT * FROM books_per_author")
@Immutable
public class BooksPerAuthorView {
    @Id
    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "num_books")
    private Integer numBooks;

    // Празен конструктор - му треба на Hibernate
    public BooksPerAuthorView() {
    }

    // Конструктор за полнење
    public BooksPerAuthorView(Long authorId, Integer numBooks) {
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