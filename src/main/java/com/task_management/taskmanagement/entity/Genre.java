package com.task_management.taskmanagement.entity;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue()
    private Long id;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    private String name;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Book> books;
}
