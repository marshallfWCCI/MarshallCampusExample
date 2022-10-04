package com.wcci.Campus;

import com.wcci.Campus.Model.Author;
import com.wcci.Campus.Model.Book;
import com.wcci.Campus.Model.Campus;
import com.wcci.Campus.Repo.AuthorRepository;
import com.wcci.Campus.Repo.BookRepository;
import com.wcci.Campus.Repo.CampusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner{

    private CampusRepository campusRepo;
    private BookRepository bookRepo;
    private AuthorRepository authorRepo;

    public Populator(CampusRepository campusRepo, BookRepository bookRepo, AuthorRepository authorRepo) {
        this.campusRepo = campusRepo;
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Campus columbus = new Campus("Columbus", "Java");
        campusRepo.save(columbus);
        Campus cleveland = new Campus("Cleveland", "C#");
        campusRepo.save(cleveland);

        Book maus = new Book("Maus", "1234567", columbus);
        bookRepo.save(maus);
        Book catcher = new Book("Catcher in the Rye", "98764321", columbus);
        bookRepo.save(catcher);
        Book ofMiceAndMen = new Book("Of Mice and Men", "13579", cleveland);
        bookRepo.save(ofMiceAndMen);

        Author salinger = new Author("J.D. Salinger", catcher, maus);
        authorRepo.save(salinger);
        Author twain = new Author("Mark Twain", ofMiceAndMen, catcher);
        authorRepo.save(twain);
    }
}
