package com.wcci.Campus.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToMany
    @JsonIgnore
    private Collection<Book> books;


    // How many parameters are in this signature?
    // A: zero, one, or two, or three, or ANY NUMBER!
    public Author(String name, Book... books) {
        this.name = name;
        this.books = Arrays.asList(books);
    }

    @Deprecated
    public Author() {
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Book> getBooks() {
        return books;
    }
}
