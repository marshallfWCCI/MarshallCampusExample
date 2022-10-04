package com.wcci.Campus.Controller;

import com.wcci.Campus.Model.Author;
import com.wcci.Campus.Model.Book;
import com.wcci.Campus.Repo.AuthorRepository;
import com.wcci.Campus.Repo.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {
    private BookRepository bookRepo;
    private AuthorRepository authorRepo;

    public BookController(BookRepository bookRepo, AuthorRepository authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @GetMapping("/books")
    public Iterable<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable long id) {
        return bookRepo.findById(id).get();
    }

    @PutMapping("/books/{id}/addAuthor")
    public Book addAuthorToBook(@PathVariable long id, @RequestBody Author author) {
        Optional<Book> existingBook = bookRepo.findById(id);
        Optional<Author> newAuthor = authorRepo.findByName(author.getName());
        if (existingBook.isPresent()) {
            if (newAuthor.isPresent()) {
                Author existingAuthor = newAuthor.get();
                if (!existingBook.get().getAuthors().contains(existingAuthor)) {
                    existingAuthor.addBook(existingBook.get());
                    authorRepo.save(existingAuthor);
                }
            }
            else {
                Author authorToAdd = new Author(author.getName(), existingBook.get());
                authorRepo.save(authorToAdd);
            }
        }
        return bookRepo.findById(id).get();
    }
}
