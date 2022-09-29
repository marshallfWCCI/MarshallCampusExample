package com.wcci.Campus.Controller;

import com.wcci.Campus.Model.Campus;
import com.wcci.Campus.Repo.CampusRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class CampusController {

    private CampusRepository campusRepo;

    public CampusController(CampusRepository campusRepo) {
        this.campusRepo = campusRepo;
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

}
