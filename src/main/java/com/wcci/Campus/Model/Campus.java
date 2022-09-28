package com.wcci.Campus.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Campus {
    @Id
    @GeneratedValue
    private long id;
    private String location;
    private String techStack;

    public Campus(String location, String techStack) {
        this.location = location;
        this.techStack = techStack;
    }

    public Campus() {

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
