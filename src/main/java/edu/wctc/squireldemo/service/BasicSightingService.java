package edu.wctc.squireldemo.service;

import edu.wctc.squireldemo.entity.Sighting;
import edu.wctc.squireldemo.repo.SightingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BasicSightingService implements SightingService{
    @Autowired
    private SightingRepository sightingRepository;

    @Override
    public void saveSighting(Sighting sighting) {
        sighting.setSpottedAt(LocalDateTime.now());
        sightingRepository.save(sighting);
    }

    @Override
    public List<Sighting> getSightingsForSquirrel(int squirrelId) {
        return sightingRepository.findAllBySquirrelIdOrderBySpottedAt(squirrelId);
    }
}
