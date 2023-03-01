package edu.wctc.squireldemo.service;

import edu.wctc.squireldemo.entity.Squirrel;

import java.util.List;

public interface SquirrelService {
    Squirrel getSquirrel(int squirrelId);
    List<Squirrel> getSquirrelList();
}
