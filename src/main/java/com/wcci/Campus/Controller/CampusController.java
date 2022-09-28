package com.wcci.Campus.Controller;

import com.wcci.Campus.Model.Campus;
import com.wcci.Campus.Repo.CampusRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CampusController {

    private CampusRepository campusRepo;

    public CampusController(CampusRepository campusRepo) {
        this.campusRepo = campusRepo;
    }

    @RequestMapping("/campuses")
    public Iterable<Campus> getCampuses() {
        return campusRepo.findAll();
    }

    @RequestMapping("/campuses/{id}")
    public Campus getCampusById(@PathVariable long id) {
        return campusRepo.findById(id).get();
    }

}
