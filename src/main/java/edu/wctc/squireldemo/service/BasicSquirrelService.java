package edu.wctc.squireldemo.service;

import edu.wctc.squireldemo.entity.Squirrel;
import edu.wctc.squireldemo.repo.SquirrelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BasicSquirrelService implements SquirrelService{

    @Autowired
    private SquirrelRepository squirrelRepository;

    @Override
    public Squirrel getSquirrel(int squirrelId) {
        Optional<Squirrel> s = squirrelRepository.findById(squirrelId);
        return s.orElse(new Squirrel());
    }

    @Override
    public List<Squirrel> getSquirrelList() {
        List<Squirrel> list = new ArrayList<>();
        squirrelRepository.findAll().forEach(list::add);
        return list;
    }
}
