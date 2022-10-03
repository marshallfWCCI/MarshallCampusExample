package com.wcci.Campus.Repo;

import com.wcci.Campus.Model.Campus;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CampusRepository extends CrudRepository<Campus, Long> {
    Optional<Campus> findByLocation(String location);
    Campus findByTechStack(String techStack);

    Campus findByLocationAndTechStack(String location, String techStack);
}
