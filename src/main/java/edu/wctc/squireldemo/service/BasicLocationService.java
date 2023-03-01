package edu.wctc.squireldemo.service;

import edu.wctc.squireldemo.entity.Location;
import edu.wctc.squireldemo.repo.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicLocationService implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getLocationList() {
        return locationRepository.findAllByOrderByCountryAscName();
    }
}
