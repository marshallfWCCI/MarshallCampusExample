package com.wcci.Campus.Controller;

import com.wcci.Campus.Model.Book;
import com.wcci.Campus.Model.Campus;
import com.wcci.Campus.Repo.BookRepository;
import com.wcci.Campus.Repo.CampusRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class CampusController {

    private CampusRepository campusRepo;

    private BookRepository bookRepo;

    public CampusController(CampusRepository campusRepo, BookRepository bookRepo) {
        this.campusRepo = campusRepo;
        this.bookRepo = bookRepo;
    }

    @GetMapping("/campuses")
    public Iterable<Campus> getCampuses() {
        return campusRepo.findAll();
    }

    @GetMapping("/campuses/{id}")
    public Campus getCampusById(@PathVariable long id) {
        return campusRepo.findById(id).get();
    }

    @PostMapping("/campuses")
    public Iterable<Campus> addNewCampus(@RequestBody Campus campus) {
        Optional<Campus> existingCampus = campusRepo.findByLocation(campus.getLocation());
        if (existingCampus.isEmpty()) {
            campusRepo.save(campus);
        }

        return campusRepo.findAll();
    }

    @PutMapping("/campuses/{id}/addBook")
    public Campus addBookToCampus(@PathVariable long id, @RequestBody Book book) {
        Optional<Campus> existingCampus = campusRepo.findById(id);
        if (existingCampus.isPresent()) {
            book.setCampus(existingCampus.get());
            bookRepo.save(book);
        }
        return campusRepo.findById(id).get();
    }



}
