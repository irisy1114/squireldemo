package edu.wctc.squireldemo.service;

import edu.wctc.squireldemo.entity.Sighting;

import java.util.List;

public interface SightingService {
    void saveSighting(Sighting sighting);
    List<Sighting> getSightingsForSquirrel(int squirrelId);
}
