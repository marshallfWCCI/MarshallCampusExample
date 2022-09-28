package com.wcci.Campus;

import com.wcci.Campus.Model.Campus;
import com.wcci.Campus.Repo.CampusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner{

    private CampusRepository campusRepo;

    public Populator(CampusRepository campusRepo) {
        this.campusRepo = campusRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Campus columbus = new Campus("Columbus", "Java");
        campusRepo.save(columbus);
        Campus cleveland = new Campus("Cleveland", "C#");
        campusRepo.save(cleveland);
    }
}
