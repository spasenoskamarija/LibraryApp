package mk.ukim.finki.emt2025.lab1.model.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany
    private List<Book> books = new ArrayList<>();

    public Wishlist() {}

    public Wishlist(Long id, User user, List<Book> books) {
        this.id = id;
        this.user = user;
        this.books = books;
    }

    public Wishlist(User user, List<Book> books) {
        this.user = user;
        this.books = books;
    }

    public Wishlist(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
