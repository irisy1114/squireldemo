package edu.wctc.squireldemo.repo;

import edu.wctc.squireldemo.entity.Sighting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SightingRepository extends CrudRepository<Sighting, Integer> {
    List<Sighting> findAllBySquirrelIdOrderBySpottedAt(int squirrelId);
}
