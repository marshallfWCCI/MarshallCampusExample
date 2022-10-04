package com.wcci.Campus.Model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Campus {
    @Id
    @GeneratedValue
    private long id;
    @Column(length=1000)
    private String location;
    private String techStack;

    @OneToMany(mappedBy = "campus")
    private Collection<Book> books;

    public Campus(String location, String techStack) {
        this.location = location;
        this.techStack = techStack;
    }

    public Campus() {

    }

    public Collection<Book> getBooks() {
        return books;
    }

    public String getLocation() {
        return location;
    }

    public String getTechStack() {
        return techStack;
    }

    public long getId() {
        return id;
    }
}
