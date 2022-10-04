package com.wcci.Campus.Repo;

import com.wcci.Campus.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
