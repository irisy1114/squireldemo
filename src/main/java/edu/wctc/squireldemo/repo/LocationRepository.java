package edu.wctc.squireldemo.repo;

import edu.wctc.squireldemo.entity.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Integer> {
    List<Location> findAllByOrderByCountryAscName();
}
