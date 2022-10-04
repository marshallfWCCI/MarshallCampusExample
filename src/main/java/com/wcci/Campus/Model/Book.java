package com.wcci.Campus.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String isbn;

    @ManyToOne
    @JsonIgnore
    private Campus campus;

    @ManyToMany(mappedBy = "books")
    private Collection<Author> authors;

    public Book(String title, String isbn, Campus campus) {
        this.title = title;
        this.isbn = isbn;
        this.campus = campus;
    }

    public Book() {
    }

    public Campus getCampus() {
        return campus;
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setCampus(Campus newCampus) {
        campus = newCampus;
    }
}
