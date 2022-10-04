package com.wcci.Campus.Repo;

import com.wcci.Campus.Model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> findByName(String name);
}
