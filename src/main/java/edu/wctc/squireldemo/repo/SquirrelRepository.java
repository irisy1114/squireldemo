package edu.wctc.squireldemo.repo;

import edu.wctc.squireldemo.entity.Squirrel;
import org.springframework.data.repository.CrudRepository;

public interface SquirrelRepository extends CrudRepository<Squirrel, Integer> {
}
