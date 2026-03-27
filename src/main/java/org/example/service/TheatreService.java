package org.example.service;

import org.example.entity.City;
import org.example.entity.Theatre;
import org.example.repository.TheatreRepository;

public class TheatreService {
    private TheatreRepository tr;

    public TheatreService(TheatreRepository tr) {
        this.tr = tr;
    }

    public void addTheatre(City c,Theatre t){
        tr.addTheatreToRepo(c,t);
    }
}
